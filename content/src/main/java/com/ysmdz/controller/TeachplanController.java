package com.ysmdz.controller;

import com.ysmdz.model.dto.CoursePlanTreeDto;
import com.ysmdz.service.TeachplanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程计划 前端控制器
 * </p>
 *
 * @author itcast
 */
@Slf4j
@RestController
@RequestMapping("/teachplan")
public class TeachplanController {

    @Autowired
    private TeachplanService teachplanService;

    /*
      根据课程id获取课程计划 每个叶子课程的课程媒资信息
     */
    @GetMapping("/oneTeachplan")
    public List<CoursePlanTreeDto> oneTeachplan(@Param("id") Long id){
        return teachplanService.oneTeachPlan(id);
    }
}
