package com.timi.edu.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timi.commonutils.ResultTemp;
import com.timi.edu.entity.Teacher;
import com.timi.edu.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Lin
 * @since 2022-03-31
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;


    //1。查询所有数据
    //rest风格
    @GetMapping("findAll")
    public ResultTemp findTeacher() {
        /*查询出所有能传输的ID*/

        List<Teacher> teacherList = teacherService.list(null);


        /* ResultTemp.ok().data("items",tableall);*/
        return ResultTemp.ok().data("items", teacherList);
    }

    @DeleteMapping("delete")
    public ResultTemp deleteTeacher() {

        Boolean a = teacherService.removeById("1");
        if (a) {
            return ResultTemp.ok();
        }
        return ResultTemp.error();
    }


    @GetMapping("page")
    public ResultTemp pageList() {

        Page<Teacher> pageParam = new Page<>(1, 3);

        teacherService.page(pageParam, null);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return ResultTemp.ok().data("total", pageParam);
    }


}

