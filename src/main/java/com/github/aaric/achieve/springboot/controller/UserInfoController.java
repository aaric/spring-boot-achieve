package com.github.aaric.achieve.springboot.controller;

import com.github.aaric.achieve.springboot.controller.api.UserInfoApi;
import com.github.aaric.achieve.springboot.entity.UserInfo;
import com.github.aaric.achieve.springboot.share.JsonMessage;
import com.github.aaric.achieve.springboot.share.ValidatedMessage;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息模块控制器
 *
 * @author Aaric, created on 2018-10-09T17:08.
 * @since 0.2.0-SNAPSHOT
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController implements UserInfoApi {

    @Override
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonMessage<UserInfo> get(@PathVariable("id") Integer id) {
        return new JsonMessage<>(new UserInfo(1, "admin", "admin"));
    }

    @Override
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public JsonMessage<List<ValidatedMessage>> signUp(@RequestBody @Validated UserInfo userInfo, BindingResult bindingResult) {
        // 打印提交信息
        System.out.println("## 提交信息");
        System.out.println(userInfo);

        // 输出数据校验信息
        if (bindingResult.hasErrors()) {
            System.out.println("## 校验信息");
            List<ValidatedMessage> validatedMessageList = new ArrayList<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
                validatedMessageList.add(new ValidatedMessage(fieldError.getField(), fieldError.getDefaultMessage()));
            }
            return new JsonMessage<>(JsonMessage.DEFAULT_CODE_VALIDATED_ERROR, validatedMessageList);
        }
        return new JsonMessage<>();
    }
}
