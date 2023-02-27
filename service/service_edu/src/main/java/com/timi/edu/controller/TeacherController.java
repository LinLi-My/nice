package com.timi.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timi.commonutils.ResultEnum;
import com.timi.commonutils.ResultTemp;
import com.timi.edu.entity.Teacher;
import com.timi.edu.entity.vo.TeacherQuery;
import com.timi.edu.service.TeacherService;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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


    @GetMapping("findAll")
    public ResultTemp findTeacher() {
        List<Teacher> teacherList = teacherService.list(null);


        Map<String, Object> A = new HashMap<>();
        A.put("teacher", teacherList);
        return ResultTemp.setReultTemp(ResultEnum.SUCCESS).data(A);


    }

    @DeleteMapping("delete")
    public ResultTemp deleteTeacher() {

        Boolean a = teacherService.removeById("1");
        if (a) {
            return ResultTemp.success();
        }
        return ResultTemp.error();
    }


    @GetMapping("page")
    public ResultTemp pageList() {

        Page<Teacher> pageParam = new Page<>(1, 3);

        teacherService.page(pageParam, null);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return ResultTemp.success().data("total", pageParam);
    }

    /**
     * Method               pageTeacherCondition
     * Description          方法描述
     * <>
     * Author               Lin
     * Date                 2022/4/1 11:05
     * Version              1.0.0
     *
     * @param
     * @return com.timi.commonutils.ResultTemp
     */
    @PostMapping("pageTeacherCondition")
    /** @RequestBody通过json对象传入参数， required = false 表示可以不传入该参数*/
    public ResultTemp pageTeacherCondition(@RequestBody(required = false) TeacherQuery teacherQuery) {

        Page<Teacher> pageParam = new Page<>(1, 3);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();

        /** 动态sql */
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        String name = teacherQuery.getName();


        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create", end);
        }


        teacherService.page(pageParam, wrapper);
        return ResultTemp.setReultTemp(ResultEnum.SUCCESS).data("TEACHER1", pageParam);

    }

    @PostMapping("save")
    public ResultTemp save(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return ResultTemp.success();

    }

    @GetMapping("{id}")
    public ResultTemp getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {

        Teacher teacher = teacherService.getById(id);
        return ResultTemp.success().data("item", teacher);
    }

    @PutMapping("{id}")
    public ResultTemp updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {

        teacher.setId(id);
        teacherService.updateById(teacher);
        return ResultTemp.success();
    }


    @GetMapping("error")

    public ResultTemp error() {


        int a = 1 / 0;


        return ResultTemp.success();
    }


}

