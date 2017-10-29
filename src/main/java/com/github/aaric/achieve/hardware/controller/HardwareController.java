package com.github.aaric.achieve.hardware.controller;

import com.github.aaric.achieve.hardware.entity.HardwareCpuInfo;
import com.github.aaric.achieve.hardware.entity.HardwareDiskInfo;
import com.github.aaric.achieve.hardware.entity.HardwareMemInfo;
import com.github.aaric.achieve.hardware.entity.HardwareNetworkInfo;
import com.github.aaric.achieve.hardware.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 硬件资源监控模块API
 *
 * @author Aaric, created on 2017-10-27T13:36.
 * @since 1.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/hardware")
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;

    /**
     * 获得当前CPU运行数据
     *
     * @return
     */
    @RequestMapping(value = "/cpu", method = RequestMethod.GET)
    public List<HardwareCpuInfo> cpu() {
        return hardwareService.getCupInfo();
    }

    /**
     * 获得当前内存运行数据
     *
     * @return
     */
    @RequestMapping(value = "/mem", method = RequestMethod.GET)
    public HardwareMemInfo mem() {
        return hardwareService.getMemInfo();
    }

    /**
     * 获得当前磁盘运行数据
     *
     * @return
     */
    @RequestMapping(value = "/disk", method = RequestMethod.GET)
    public HardwareDiskInfo disk() {
        return hardwareService.getDiskInfo();
    }

    /**
     * 获得当前网络运行数据
     *
     * @return
     */
    @RequestMapping(value = "/network", method = RequestMethod.GET)
    public HardwareNetworkInfo network() {
        return hardwareService.getNetworkInfo();
    }
}
