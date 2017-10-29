package com.github.aaric.achieve.hardware.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 网络运行数据信息
 *
 * @author Aaric, created on 2017-10-27T15:09.
 * @since 1.0-SNAPSHOT
 */
public class HardwareNetworkInfo {

    /**
     * 每秒接收总字节数
     */
    private Long rxBytesPerSeconds;

    /**
     * 每秒发送总字节数
     */
    private Long txBytesPerSeconds;

    /**
     * 采集时间
     */
    private Date detectionTime;

    public HardwareNetworkInfo() {
    }

    public HardwareNetworkInfo(Long rxBytesPerSeconds, Long txBytesPerSeconds) {
        this.rxBytesPerSeconds = rxBytesPerSeconds;
        this.txBytesPerSeconds = txBytesPerSeconds;
    }

    public Long getRxBytesPerSeconds() {
        return rxBytesPerSeconds;
    }

    public void setRxBytesPerSeconds(Long rxBytesPerSeconds) {
        this.rxBytesPerSeconds = rxBytesPerSeconds;
    }

    public Long getTxBytesPerSeconds() {
        return txBytesPerSeconds;
    }

    public void setTxBytesPerSeconds(Long txBytesPerSeconds) {
        this.txBytesPerSeconds = txBytesPerSeconds;
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
