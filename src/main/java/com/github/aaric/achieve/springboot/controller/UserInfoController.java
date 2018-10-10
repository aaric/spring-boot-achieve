package com.github.aaric.achieve.springboot.controller;

import com.github.aaric.achieve.springboot.controller.api.UserInfoApi;
import com.github.aaric.achieve.springboot.entity.UserInfo;
import com.github.aaric.achieve.springboot.share.JsonMessage;
import com.github.aaric.achieve.springboot.share.ValidatedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 用户信息模块控制器
 *
 * @author Aaric, created on 2018-10-09T17:08.
 * @since 0.2.0-SNAPSHOT
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController implements UserInfoApi {

    @Autowired
    private MessageSource messageSource;

    /**
     * 获得本地化字符串
     *
     * @param code i18n编码
     * @return
     */
    private String getMessage(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }

    @Override
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonMessage<UserInfo> get(@PathVariable("id") Integer id) {
        return new JsonMessage<>(new UserInfo(1, "admin", getMessage("hello")));
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
