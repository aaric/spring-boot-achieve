package com.github.aaric.achieve.springboot.share;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 数据校验信息
 *
 * @author Aaric, created on 2018-10-10T21:25.
 * @since 0.3.0-SNAPSHOT
 */
public class ValidatedMessage {

    /**
     * 校验失败字段
     */
    @ApiModelProperty(position = 1, value = "校验字段")
    private String field;

    /**
     * 校验失败信息
     */
    @ApiModelProperty(position = 2, value = "校验失败原因")
    private String message;

    public ValidatedMessage() {
    }

    public ValidatedMessage(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
