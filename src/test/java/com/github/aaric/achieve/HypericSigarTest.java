package com.github.aaric.achieve;

import org.hyperic.sigar.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * HypericSigarTest
 *
 * @author Aaric, created on 2017-10-26T13:38.
 * @since 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HypericSigarTest {

    @Autowired
    protected Sigar sigar;

    @Test
    public void testCpuInfo() throws SigarException {
        System.out.println("-- CpuInfo");
        CpuInfo[] cpuInfos = sigar.getCpuInfoList();
        if (null != cpuInfos && 0 < cpuInfos.length) {
            CpuInfo info;
            for (int i = 0; i < cpuInfos.length; i++) {
                info = cpuInfos[i];
                System.out.println("--> " + i);
                System.out.println(info.getVendor());
                System.out.println(info.getModel());
                System.out.println(info.getMhz());
            }
        }

        System.out.println();
        System.out.println("-- CpuPerc");
        CpuPerc[] cpuPercs = sigar.getCpuPercList();
        if (null != cpuPercs && 0 < cpuPercs.length) {
            CpuPerc perc;
            for (int i = 0; i < cpuPercs.length; i++) {
                perc = cpuPercs[i];
                System.out.println("--> " + i);
                System.out.println(CpuPerc.format(perc.getUser()));
                System.out.println(CpuPerc.format(perc.getSys()));
            }
        }
    }

    @Test
    public void testMemInfo() throws SigarException {
        System.out.println("-- Mem");
        Mem mem = sigar.getMem();
        System.out.println(mem.getTotal());
        System.out.println(mem.getUsed());
        System.out.println(mem.getFree());

        System.out.println();
        System.out.println("-- Mem");
        Swap swap = sigar.getSwap();
        System.out.println(swap.getTotal());
        System.out.println(swap.getUsed());
        System.out.println(swap.getFree());
    }

    @Test
    public void testHostnameInfo() throws SigarException {
        System.out.println(sigar.getNetInfo().getHostName());
    }

    @Test
    public void testDiskInfo() throws SigarException {
        FileSystem[] fileSystems = sigar.getFileSystemList();
        if (null != fileSystems && 0 < fileSystems.length) {
            FileSystem fs;
            FileSystemUsage usage;
            for (int i = 0; i < fileSystems.length; i++) {
                fs = fileSystems[i];
                if (FileSystem.TYPE_LOCAL_DISK == fs.getType()) {
                    System.out.println("--> " + i);
                    System.out.println(fs.getDevName());
                    System.out.println(fs.getSysTypeName());
                    usage = sigar.getFileSystemUsage(fs.getDirName());
                    System.out.println(usage.getTotal());
                    System.out.println(usage.getUsed());
                    System.out.println(usage.getAvail());
                    System.out.println(usage.getUsePercent());
                    System.out.println(usage.getDiskWriteBytes());
                    System.out.println(usage.getDiskReadBytes());
                }
            }
        }
    }

    @Test
    public void testNetworkInfo() throws SigarException {
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
                    System.out.println("--> " + i);
                    System.out.println(name);
                    System.out.println(networkConfig.getAddress());
                    System.out.println(networkConfig.getNetmask());
                    System.out.println(newworkStat.getRxBytes());
                    System.out.println(newworkStat.getTxBytes());
                }
            }
        }
    }
}
