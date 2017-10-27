package com.github.aaric.achieve.hardware.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 内存运行数据信息
 *
 * @author Aaric, created on 2017-10-27T14:00.
 * @since 1.0-SNAPSHOT
 */
public class HardwareMemInfo {

    /**
     * 总量(单位KB)
     */
    private Long total;

    /**
     * 使用量(单位KB)
     */
    private Long used;

    /**
     * 空闲(单位KB)
     */
    private Long free;

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

    public HardwareMemInfo() {
    }

    public HardwareMemInfo(Long total, Long used, Long free) {
        this.total = total;
        this.used = used;
        this.free = free;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getUsed() {
        return used;
    }

    public void setUsed(Long used) {
        this.used = used;
    }

    public Long getFree() {
        return free;
    }

    public void setFree(Long free) {
        this.free = free;
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
