/**
 * ClassName:
 * Description:
 * Date:           2022 2022/4/1 15:05
 * Author:         Lin
 * Copyright:      Lin
 */


package com.timi.servicebase.execeptionhandler;

import com.timi.commonutils.ResultEnum;
import com.timi.commonutils.ResultTemp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //有参构造函数
@NoArgsConstructor  //无参构造函数
public class MyException extends RuntimeException {

    private ResultEnum resultEnum;

}
