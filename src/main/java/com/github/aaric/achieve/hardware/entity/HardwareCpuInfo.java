package com.github.aaric.achieve.hardware.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * CPU运行数据信息
 *
 * @author Aaric, created on 2017-10-27T13:50.
 * @since 1.0-SNAPSHOT
 */
public class HardwareCpuInfo {

    /**
     * 制造商
     */
    private String vendor;

    /**
     * 型号
     */
    private String model;

    /**
     * MHz
     */
    private Integer mhz;

    /**
     * 使用率
     */
    private Double usedPercent;

    /**
     * 空闲率
     */
    private Double freePercent;

    /**
     * 采集时间
     */
    private Date detectionTime;

    public HardwareCpuInfo() {
    }

    public HardwareCpuInfo(String vendor, String model, Integer mhz) {
        this.vendor = vendor;
        this.model = model;
        this.mhz = mhz;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMhz() {
        return mhz;
    }

    public void setMhz(Integer mhz) {
        this.mhz = mhz;
    }

    public Double getUsedPercent() {
        return usedPercent;
    }

    public void setUsedPercent(Double usedPercent) {
        this.usedPercent = usedPercent;
    }

    public Double getFreePercent() {
        return freePercent;
    }

    public void setFreePercent(Double freePercent) {
        this.freePercent = freePercent;
    }

    public Date getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(Date detectionTime) {
        this.detectionTime = detectionTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
