package com.github.aaric.achieve.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

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
    @NotBlank(message = "{username.not.null.error}") //用户名不能为空
    @Length(min = 5, max = 10, message = "{username.min.max.error}") //用户名必须是5-10个字符
    @ApiModelProperty(position = 2, value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(position = 3, value = "密码")
    private String password;

    /**
     * 电子邮箱
     */
    @NotBlank(message = "{email.not.null.error}") //电子邮箱不能为空
    @Email(message = "{email.format.error}") //电子邮箱格式不正确
    @ApiModelProperty(position = 4, value = "电子邮箱")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
