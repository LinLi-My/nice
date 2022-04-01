/**
 * ClassName:
 * Description:
 * Date:           2022 2022/4/1 14:31
 * Author:         Lin
 * Copyright:      Lin
 */


package com.timi.servicebase.execeptionhandler;

import com.timi.commonutils.ResultEnum;
import com.timi.commonutils.ResultTemp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    //指定出现什么异常执行这个方法 Exception（所有异常）、ArithmeticException（运算异常）
    /**
     * 全局异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultTemp error(Exception e){
        e.printStackTrace();
        return ResultTemp.setReultTemp(ResultEnum.EXECTPION);
    }


    /**
     *  特定异常处理
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResultTemp error2(ArithmeticException e){
        String fullStackTrace = ExceptionUtils.getStackTrace(e);
        log.error("---------"+fullStackTrace );

        e.printStackTrace();
        return ResultTemp.setReultTemp(ResultEnum.AEXECTPION).data("堆栈",fullStackTrace);
    }


    /**
     *  自定义异常处理
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResultTemp error2(MyException e){
        log.error(e.getResultEnum().getCode()+e.getResultEnum().getMessage());
        e.printStackTrace();
        return ResultTemp.setReultTemp(e.getResultEnum()).data("xx", e.getResultEnum().getCode()+e.getResultEnum().getMessage());
    }

}
