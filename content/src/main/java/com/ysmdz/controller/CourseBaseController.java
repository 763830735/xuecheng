package com.ysmdz.controller;

import com.ysmdz.fun.CourseBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程基本信息 前端控制器
 * </p>
 *
 * @author itcast
 */
@Slf4j
@RestController
@RequestMapping("/courseBase")
@Tag(name = "CourseBaseController", description = "课程管理")
public class CourseBaseController{
    @Autowired
    private CourseBaseService courseBaseService;

    @Operation(summary = "根据分页查询课程信息")
    @GetMapping("/queryCourse")
    public List<Map<String,Object>> listCourseBase(@RequestBody Map<String,String> map){
        return courseBaseService.queryCourse(map);
    }

//
//    @Operation(summary = "新增课程")
//    @PostMapping("/addCourse")
//    public boolean addCourse(@RequestBody NewCourseVo newCourseVo){
//        return courseBaseService.addCourse(newCourseVo);
//    }

//    @Operation(summary = "查询某一课程")
//    @GetMapping("/oneCourseBase")
//    public List<UpdateCourseDto> oneCourseBase(@Param("id") Long id){
//        return courseBaseService.oneCourseBase(id);
//    }
}
