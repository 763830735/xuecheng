package com.ysmdz.controller;

import com.ysmdz.fun.TeachplanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
      根据课程id获取课程计划和课程媒资信息
     */
    @GetMapping("/queryAllTeachplan")
    public List<Map<String,Object>> queryAllTeachplan(@RequestBody Map<String,String> map){
        return teachplanService.queryAllTeachplan(Long.valueOf(map.get("courseId")));
    }

    @PostMapping("insertTeachPlan")
    public Map<String,Object> insertTeachPlan(@RequestBody Map<String,String> map){
        return teachplanService.insertTeachPlan(map);
    }
}
