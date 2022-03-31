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
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private ResultTemp() {
    }

    public static ResultTemp ok() {
        ResultTemp r = new ResultTemp();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static ResultTemp error() {
        ResultTemp r = new ResultTemp();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public ResultTemp success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public ResultTemp message(String message) {
        this.setMessage(message);
        return this;
    }

    public ResultTemp code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ResultTemp data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ResultTemp data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}
