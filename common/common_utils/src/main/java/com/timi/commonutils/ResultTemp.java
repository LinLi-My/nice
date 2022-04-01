/**
 * ClassName:
 * Description:
 * Date:           2022 2022/3/31 22:47
 * Author:         47142
 * Copyright:      47142
 */


package com.timi.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultTemp {
    @ApiModelProperty(value = "是否成功")
    private Boolean state;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private ResultTemp() {
    }

    public static ResultTemp success() {
        ResultTemp r = new ResultTemp();
        r.setState(ResultEnum.SUCCESS.getState());
        r.setCode(ResultEnum.SUCCESS.getCode());
        r.setMessage(ResultEnum.SUCCESS.getMessage());
        return r;
    }

    public static ResultTemp error() {
        ResultTemp r = new ResultTemp();
        r.setState(ResultEnum.FAIL.getState());
        r.setCode(ResultEnum.FAIL.getCode());
        r.setMessage(ResultEnum.FAIL.getMessage());
        return r;
    }

    public static ResultTemp setReultTemp(ResultEnum resultEnum) {
        ResultTemp r = new ResultTemp();
        r.setState(resultEnum.getState());
        r.setCode(resultEnum.getCode());
        r.setMessage(resultEnum.getMessage());
        return r;
    }



    public ResultTemp data(String s, Object value) {
        this.data.put(s,value);
        return this;
    }

    public ResultTemp data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }




}
