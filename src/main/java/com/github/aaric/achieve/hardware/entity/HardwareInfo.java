package com.github.aaric.achieve.hardware.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Redis缓存服务器运行数据实体
 *
 * @author Aaric, created on 2017-10-30T16:30.
 * @since 1.0-SNAPSHOT
 */
public class HardwareInfo {

    /**
     * CPU负载百分比
     */
    private Float cpuPercent;

    /**
     * 内存空间大小（单位比特）
     */
    private Long memTotal;
    /**
     * 已使用内存空间大小（单位比特）
     */
    private Long memUsed;
    /**
     * 空闲内存空间大小（单位比特）
     */
    private Long memFree;
    /**
     * 内存空间使用百分比
     */
    private Float memPercent;
    /**
     * Swap空间大小（单位比特）
     */
    private Long swapTotal;
    /**
     * 已使用Swap空间大小（单位比特）
     */
    private Long swapUsed;
    /**
     * 空闲Swap空间大小（单位比特）
     */
    private Long swapFree;
    /**
     * Swap空间使用百分比
     */
    private Float swapPercent;

    /**
     * 磁盘空间大小（单位比特）
     */
    private Long diskTotal;
    /**
     * 已使用磁盘空间大小（单位比特）
     */
    private Long diskUsed;
    /**
     * 空闲磁盘空间大小（单位比特）
     */
    private Long diskFree;
    /**
     * 磁盘空间使用百分比
     */
    private Float diskPercent;
    /**
     * 读磁盘IO字节数
     */
    private Long diskIoReadBytes;
    /**
     * 每秒读磁盘IO字节数
     */
    private Long diskIoReadBytesPer;
    /**
     * 写磁盘IO字节数
     */
    private Long diskIoWriteBytes;
    /**
     * 每秒读磁盘IO字节数
     */
    private Long diskIoWriteBytesPer;

    /**
     * 发送网络字节数
     */
    private Long networkSendBytes;
    /**
     * 每秒发送网络字节数
     */
    private Long networkSendBytesPer;
    /**
     * 接收网络字节数
     */
    private Long networkRecvBytes;
    /**
     * 每秒接收网络字节数
     */
    private Long networkRecvBytesPer;

    /**
     * 采集时间
     */
    private Date collectTime;

    public HardwareInfo() {
    }

    public HardwareInfo(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Float getCpuPercent() {
        return cpuPercent;
    }

    public void setCpuPercent(Float cpuPercent) {
        this.cpuPercent = cpuPercent;
    }

    public Long getMemTotal() {
        return memTotal;
    }

    public void setMemTotal(Long memTotal) {
        this.memTotal = memTotal;
    }

    public Long getMemUsed() {
        return memUsed;
    }

    public void setMemUsed(Long memUsed) {
        this.memUsed = memUsed;
    }

    public Long getMemFree() {
        return memFree;
    }

    public void setMemFree(Long memFree) {
        this.memFree = memFree;
    }

    public Float getMemPercent() {
        return memPercent;
    }

    public void setMemPercent(Float memPercent) {
        this.memPercent = memPercent;
    }

    public Long getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(Long swapTotal) {
        this.swapTotal = swapTotal;
    }

    public Long getSwapUsed() {
        return swapUsed;
    }

    public void setSwapUsed(Long swapUsed) {
        this.swapUsed = swapUsed;
    }

    public Long getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(Long swapFree) {
        this.swapFree = swapFree;
    }

    public Float getSwapPercent() {
        return swapPercent;
    }

    public void setSwapPercent(Float swapPercent) {
        this.swapPercent = swapPercent;
    }

    public Long getDiskTotal() {
        return diskTotal;
    }

    public void setDiskTotal(Long diskTotal) {
        this.diskTotal = diskTotal;
    }

    public Long getDiskUsed() {
        return diskUsed;
    }

    public void setDiskUsed(Long diskUsed) {
        this.diskUsed = diskUsed;
    }

    public Long getDiskFree() {
        return diskFree;
    }

    public void setDiskFree(Long diskFree) {
        this.diskFree = diskFree;
    }

    public Float getDiskPercent() {
        return diskPercent;
    }

    public void setDiskPercent(Float diskPercent) {
        this.diskPercent = diskPercent;
    }

    public Long getDiskIoReadBytes() {
        return diskIoReadBytes;
    }

    public void setDiskIoReadBytes(Long diskIoReadBytes) {
        this.diskIoReadBytes = diskIoReadBytes;
    }

    public Long getDiskIoReadBytesPer() {
        return diskIoReadBytesPer;
    }

    public void setDiskIoReadBytesPer(Long diskIoReadBytesPer) {
        this.diskIoReadBytesPer = diskIoReadBytesPer;
    }

    public Long getDiskIoWriteBytes() {
        return diskIoWriteBytes;
    }

    public void setDiskIoWriteBytes(Long diskIoWriteBytes) {
        this.diskIoWriteBytes = diskIoWriteBytes;
    }

    public Long getDiskIoWriteBytesPer() {
        return diskIoWriteBytesPer;
    }

    public void setDiskIoWriteBytesPer(Long diskIoWriteBytesPer) {
        this.diskIoWriteBytesPer = diskIoWriteBytesPer;
    }

    public Long getNetworkSendBytes() {
        return networkSendBytes;
    }

    public void setNetworkSendBytes(Long networkSendBytes) {
        this.networkSendBytes = networkSendBytes;
    }

    public Long getNetworkSendBytesPer() {
        return networkSendBytesPer;
    }

    public void setNetworkSendBytesPer(Long networkSendBytesPer) {
        this.networkSendBytesPer = networkSendBytesPer;
    }

    public Long getNetworkRecvBytes() {
        return networkRecvBytes;
    }

    public void setNetworkRecvBytes(Long networkRecvBytes) {
        this.networkRecvBytes = networkRecvBytes;
    }

    public Long getNetworkRecvBytesPer() {
        return networkRecvBytesPer;
    }

    public void setNetworkRecvBytesPer(Long networkRecvBytesPer) {
        this.networkRecvBytesPer = networkRecvBytesPer;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
