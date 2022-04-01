/**
 * ClassName:
 * Description:
 * Date:           2022 2022/4/1 8:53
 * Author:         Lin
 * Copyright:      Lin
 */


package com.timi.commonutils;

import lombok.Getter;

@Getter
public enum ResultEnum {


    /**
     *   成功
     */
    SUCCESS(true,1000,"验证通过"),

    /**
     *   成功
     */
    FAIL(false ,2000,"验证通过"),


    /**
     *  异常
     */
    EXECTPION(false,-1,"全局异常处理"),

    /**
     *  异常
     */
    AEXECTPION(false,-2,"特定异常-计算异常"),

    /**
     *  异常
     */
    MYEXECTPION(false,-3,"自定义异常");
    /**
     *   状态码
     */
    private Boolean state;


    /**
     *   状态码
     */
    private Integer code;

    /**
     *  状态信息
     */
    private String message;


    private ResultEnum(Boolean state, Integer code, String message) {
        this.state = state;
        this.code = code;
        this.message = message;
    }
}
