package com.github.aaric.achieve.springboot.share;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * JSON规范对象
 *
 * @author Aaric, created on 2018-10-10T14:58.
 * @since 0.2.2-SNAPSHOT
 */
@ApiModel(description = "JSON规范对象")
public class JsonMessage<T> {

    /**
     * 默认成功状态码
     */
    public static final String DEFAULT_CODE_SUCCESS = "0000";

    /**
     * 默认成功说明信息
     */
    public static final String DEFAULT_MESSAGE_SUCCESS = "SUCCESS";

    /**
     * 状态码，0000表示正常，其他表示异常
     */
    @ApiModelProperty(position = 1, value = "返回码，0000表示正常，其他表示异常")
    private String code;

    /**
     * 说明信息
     */
    @ApiModelProperty(position = 2, value = "说明信息")
    private String message;

    /**
     * 数据对象
     */
    @ApiModelProperty(position = 3, value = "数据对象")
    private T data;

    public JsonMessage() {
        this.code = DEFAULT_CODE_SUCCESS;
        this.message = DEFAULT_MESSAGE_SUCCESS;
    }

    public JsonMessage(T data) {
        this();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
