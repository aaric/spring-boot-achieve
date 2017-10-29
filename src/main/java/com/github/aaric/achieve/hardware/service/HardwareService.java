package com.github.aaric.achieve.hardware.service;

import com.github.aaric.achieve.hardware.entity.HardwareCpuInfo;
import com.github.aaric.achieve.hardware.entity.HardwareDiskInfo;
import com.github.aaric.achieve.hardware.entity.HardwareMemInfo;
import com.github.aaric.achieve.hardware.entity.HardwareNetworkInfo;

import java.util.List;

/**
 * 硬件资源监控Service接口
 *
 * @author Aaric, created on 2017-10-27T13:37.
 * @since 1.0-SNAPSHOT
 */
public interface HardwareService {

    /**
     * 获得当前CPU运行数据
     *
     * @return
     */
    List<HardwareCpuInfo> getCupInfo();

    /**
     * 获得当前内存运行数据
     *
     * @return
     */
    HardwareMemInfo getMemInfo();

    /**
     * 获得当前磁盘运行数据
     *
     * @return
     */
    HardwareDiskInfo getDiskInfo();

    /**
     * 获得当前网络运行数据
     *
     * @return
     */
    HardwareNetworkInfo getNetworkInfo();
}
