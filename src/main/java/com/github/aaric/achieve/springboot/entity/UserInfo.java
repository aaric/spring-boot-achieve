package com.github.aaric.achieve.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息
 *
 * @author Aaric, created on 2018-10-09T17:13.
 * @since 0.2.0-SNAPSHOT
 */
@ApiModel(description = "用户信息")
public class UserInfo {

    /**
     * ID
     */
    @ApiModelProperty(position = 1, value = "ID")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(position = 1, value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(position = 1, value = "密码")
    private String password;

    public UserInfo() {
    }

    public UserInfo(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
