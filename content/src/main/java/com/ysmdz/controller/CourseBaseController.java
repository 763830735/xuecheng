package com.ysmdz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ysmdz.model.vo.QueryCourseParamsVo;
import com.ysmdz.service.CourseBaseService;
import com.ysmdz.util.PageUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

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
    @GetMapping("/list")
    public void list(@RequestBody QueryCourseParamsVo paramsVo){
            
    }
}
