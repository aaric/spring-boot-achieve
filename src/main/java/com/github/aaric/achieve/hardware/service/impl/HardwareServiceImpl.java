package com.github.aaric.achieve.hardware.service.impl;

import com.github.aaric.achieve.hardware.entity.HardwareCpuInfo;
import com.github.aaric.achieve.hardware.entity.HardwareDiskInfo;
import com.github.aaric.achieve.hardware.entity.HardwareMemInfo;
import com.github.aaric.achieve.hardware.entity.HardwareNetworkInfo;
import com.github.aaric.achieve.hardware.service.HardwareService;
import org.hyperic.sigar.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 硬件资源监控Service接口实现
 *
 * @author Aaric, created on 2017-10-27T13:37.
 * @since 1.0-SNAPSHOT
 */
@Service
public class HardwareServiceImpl implements HardwareService {

    /**
     * History data
     */
    private static Map<String, Long> mapDataHistory = new HashMap<>();

    /**
     * History time
     */
    private static Map<String, Date> mapTimeHistory = new HashMap<>();

    @Autowired
    private Sigar sigar;

    @Override
    public List<HardwareCpuInfo> getCupInfo() {
        List<HardwareCpuInfo> cpuInfoList = new ArrayList<>();

        try {
            // 制造商信息
            CpuInfo[] cpuInfos = sigar.getCpuInfoList();

            // 运行数据
            CpuPerc[] cpuPercs = sigar.getCpuPercList();

            // 构建完整数据信息
            Date current = Calendar.getInstance().getTime();
            if ((null != cpuInfos && 0 < cpuInfos.length) && (null != cpuPercs && 0 < cpuPercs.length)) {
                CpuInfo cpuInfo;
                CpuPerc cpuPerc;
                HardwareCpuInfo hardwareCpuInfo;
                for (int i = 0; i < cpuInfos.length; i++) {
                    cpuInfo = cpuInfos[i];
                    cpuPerc = cpuPercs[i];
                    hardwareCpuInfo = new HardwareCpuInfo(cpuInfo.getVendor(), cpuInfo.getModel(), cpuInfo.getMhz());
                    hardwareCpuInfo.setUsedPercent(cpuPerc.getUser() + cpuPerc.getSys()); // user + system
                    /*hardwareCpuInfo.setFreePercent(cpuPerc.getSys());*/
                    hardwareCpuInfo.setFreePercent(1 - hardwareCpuInfo.getUsedPercent());
                    hardwareCpuInfo.setDetectionTime(current);
                    cpuInfoList.add(hardwareCpuInfo);
                }
            }

        } catch (SigarException e) {
            e.printStackTrace();
        }
        return cpuInfoList;
    }

    @Override
    public HardwareMemInfo getMemInfo() {
        Mem mem = null;
        HardwareMemInfo hardwareMemInfo = null;
        try {
            // 内存数据
            mem = sigar.getMem();
            hardwareMemInfo = new HardwareMemInfo(mem.getTotal(), mem.getUsed(), mem.getFree());
            // 使用率和空闲率
            hardwareMemInfo.setUsedPercent(Double.valueOf(mem.getUsed() * 1.0F / mem.getTotal()));
            hardwareMemInfo.setFreePercent(Double.valueOf(mem.getFree() * 1.0F / mem.getTotal()));
            hardwareMemInfo.setDetectionTime(Calendar.getInstance().getTime());

        } catch (SigarException e) {
            e.printStackTrace();
        }
        return hardwareMemInfo;
    }

    @Override
    public HardwareDiskInfo getDiskInfo() {
        // 定义累加和变量
        Long totalSum = 0L;
        Long usedSum = 0L;
        Long freeSum = 0L;
        Long writeSum = 0L;
        Long readSum = 0L;

        // 获得运行数据累加和
        try {
            FileSystem[] fileSystems = sigar.getFileSystemList();
            if (null != fileSystems && 0 < fileSystems.length) {
                FileSystem fs;
                FileSystemUsage usage;
                for (int i = 0; i < fileSystems.length; i++) {
                    fs = fileSystems[i];
                    if (FileSystem.TYPE_LOCAL_DISK == fs.getType()) {
                        usage = sigar.getFileSystemUsage(fs.getDirName());
                        if (null != usage) {
                            totalSum += usage.getTotal();
                            usedSum += usage.getUsed();
                            freeSum += usage.getAvail();
                            writeSum += usage.getDiskWrites();
                            readSum += usage.getDiskReads();
                        }
                    }
                }
            }
        } catch (SigarException e) {
            e.printStackTrace();
        }

        // 计算运行数据信息
        Date current = Calendar.getInstance().getTime();
        HardwareDiskInfo hardwareDiskInfo = new HardwareDiskInfo(totalSum, usedSum, freeSum);
        hardwareDiskInfo.setUsedPercent(Double.valueOf(usedSum / (0 == totalSum ? 1 : totalSum)));
        /*hardwareDiskInfo.setFreePercent(Double.valueOf(freeSum / (0 == totalSum ? 1 : totalSum)));*/
        hardwareDiskInfo.setFreePercent(1 - hardwareDiskInfo.getUsedPercent());

        // 计算与时间统计相关
        String writeSumKey = "writeSum";
        String readSumKey = "readSum";
        if (null != mapDataHistory.get(writeSumKey) && null != mapDataHistory.get(readSumKey)) {
            hardwareDiskInfo.setWritePerSeconds((writeSum - mapDataHistory.get(writeSumKey)) / (current.getTime() - mapTimeHistory.get(writeSumKey).getTime()) / 1000);
            hardwareDiskInfo.setReadPerSeconds((writeSum - mapDataHistory.get(readSumKey)) / (current.getTime() - mapTimeHistory.get(readSumKey).getTime()) / 1000);
        }
        mapDataHistory.put(writeSumKey, writeSum);
        mapTimeHistory.put(writeSumKey, current);
        mapDataHistory.put(readSumKey, readSum);
        mapTimeHistory.put(readSumKey, current);
        hardwareDiskInfo.setDetectionTime(current);
        return hardwareDiskInfo;
    }

    @Override
    public HardwareNetworkInfo getNetworkInfo() {
        // 定义累加和变量
        Long rxBytesSum = 0L;
        Long txBytesSum = 0L;

        // 获得运行数据累加和
        try {
            String[] networkNames = sigar.getNetInterfaceList();
            if (null != networkNames && 0 < networkNames.length) {
                String name;
                NetInterfaceConfig networkConfig;
                NetInterfaceStat newworkStat;
                for (int i = 0; i < networkNames.length; i++) {
                    name = networkNames[i];
                    networkConfig = sigar.getNetInterfaceConfig(name);
                    newworkStat = sigar.getNetInterfaceStat(name);
                    if (null != networkConfig && !"0.0.0.0".equals(networkConfig.getAddress())) {
                        rxBytesSum += newworkStat.getRxBytes();
                        rxBytesSum += newworkStat.getTxBytes();
                    }
                }
            }

        } catch (SigarException e) {
            e.printStackTrace();
        }

        // 计算与时间统计相关
        String rxBytesSumKey = "rxBytesSum";
        String txBytesSumKey = "txBytesSum";
        Date current = Calendar.getInstance().getTime();
        HardwareNetworkInfo hardwareNetworkInfo = new HardwareNetworkInfo(0L, 0L);
        if (null != mapDataHistory.get(rxBytesSumKey) && null != mapDataHistory.get(txBytesSumKey)) {
            hardwareNetworkInfo.setRxBytesPerSeconds((rxBytesSum - mapDataHistory.get(rxBytesSumKey)) / (current.getTime() - mapTimeHistory.get(rxBytesSumKey).getTime()) / 1000);
            hardwareNetworkInfo.setTxBytesPerSeconds(txBytesSum - mapDataHistory.get(txBytesSumKey) / (current.getTime() - mapTimeHistory.get(txBytesSumKey).getTime()) / 1000);
        }
        mapDataHistory.put(rxBytesSumKey, rxBytesSum);
        mapTimeHistory.put(rxBytesSumKey, current);
        mapDataHistory.put(txBytesSumKey, txBytesSum);
        mapTimeHistory.put(txBytesSumKey, current);
        hardwareNetworkInfo.setDetectionTime(current);
        return hardwareNetworkInfo;
    }
}
