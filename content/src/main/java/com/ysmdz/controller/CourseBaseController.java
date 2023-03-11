package com.ysmdz.controller;

import com.ysmdz.model.dto.CourseBaseDTO;
import com.ysmdz.model.po.CourseBase;
import com.ysmdz.model.vo.QueryCourseParamsVo;
import com.ysmdz.service.CourseBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @Operation(summary = "分页根据条件查询课程信息")
    @GetMapping("/listCourseBase")
    public List<CourseBaseDTO> listCourseBase(@RequestBody QueryCourseParamsVo paramsVo){
        return courseBaseService.listCourseBase(paramsVo);
    }
}
