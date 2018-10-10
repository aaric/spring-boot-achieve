package com.github.aaric.achieve.springboot.controller.api;

import com.github.aaric.achieve.springboot.entity.UserInfo;
import com.github.aaric.achieve.springboot.share.JsonMessage;
import com.github.aaric.achieve.springboot.share.ValidatedMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * 用户信息模块API
 *
 * @author Aaric, created on 2018-10-09T17:10.
 * @since 0.2.0-SNAPSHOT
 */
@Api(description = "用户信息模块API")
public interface UserInfoApi {

    /**
     * 获得用户信息
     *
     * @param id 用户ID
     * @return
     */
    @ApiOperation("获得用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer", paramType = "path", required = true, defaultValue = "1")
    })
    JsonMessage<UserInfo> get(Integer id);

    /**
     * 注册用户信息
     *
     * @param userInfo      用户信息
     * @param bindingResult 数据校验结果
     * @return
     * @author Aaric
     * @version 0.3.0-SNAPSHOT
     */
    @ApiOperation("注册用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userInfo", value = "用户名", dataType = "UserInfo", paramType = "body", required = true)
    })
    JsonMessage<List<ValidatedMessage>> signUp(UserInfo userInfo, BindingResult bindingResult);
}
