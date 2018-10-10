package com.github.aaric.achieve.springboot.controller;

import com.github.aaric.achieve.springboot.controller.api.UserInfoApi;
import com.github.aaric.achieve.springboot.entity.UserInfo;
import com.github.aaric.achieve.springboot.share.JsonMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息模块控制器
 *
 * @author Aaric, created on 2018-10-09T17:08.
 * @since 0.2.0-SNAPSHOT
 */
@RestController
@RequestMapping("/user/info")
public class UserInfoController implements UserInfoApi {

    @Override
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonMessage<UserInfo> get(@PathVariable("id") Integer id) {
        return new JsonMessage<>(new UserInfo(1, "admin", "admin"));
    }
}
