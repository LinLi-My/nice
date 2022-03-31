package com.timi.edu.controller;


import com.timi.edu.entity.Teacher;
import com.timi.edu.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("findAll")
    public List<Teacher> findTeacher() {

        List<Teacher> teacherList = teacherService.list(null);
        return teacherList;
    }

}

