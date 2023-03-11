package com.ysmdz.controller;

import com.ysmdz.model.dto.CourseBaseDTO;
import com.ysmdz.model.dto.UpdateCourseDto;
import com.ysmdz.model.po.CourseBase;
import com.ysmdz.model.vo.NewCourseVo;
import com.ysmdz.model.vo.QueryCourseParamsVo;
import com.ysmdz.service.CourseBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Operation(summary = "根据条件分页查询课程信息")
    @GetMapping("/listCourseBase")
    public List<CourseBaseDTO> listCourseBase(@RequestBody QueryCourseParamsVo paramsVo){
        return courseBaseService.listCourseBase(paramsVo);
    }

    @Operation(summary = "新增课程")
    @PostMapping("/addCourse")
    public boolean addCourse(@RequestBody NewCourseVo newCourseVo){
        return courseBaseService.addCourse(newCourseVo);
    }

    @Operation(summary = "查询某一课程")
    @GetMapping("/oneCourseBase")
    public List<UpdateCourseDto> oneCourseBase(@Param("id") Long id){
        return courseBaseService.oneCourseBase(id);
    }
}
