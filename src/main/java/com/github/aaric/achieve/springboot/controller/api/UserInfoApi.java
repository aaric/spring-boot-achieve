package com.github.aaric.achieve.springboot.controller.api;

import com.github.aaric.achieve.springboot.entity.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
    //@ApiOperation(value = "获得用户信息", notes = "根据用户ID获得用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Integer", paramType = "path", required = true)
    })
    UserInfo get(Integer id);
}
