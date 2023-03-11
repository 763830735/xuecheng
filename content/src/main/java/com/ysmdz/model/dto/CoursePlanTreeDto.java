package com.ysmdz.model.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CoursePlanTreeDto {
    private Long id;

    /**
     * 课程计划名称
     */
    private String pname;

    /**
     * 课程计划父级Id
     */
    private Long parentid;

    /**
     * 层级，分为1、2、3级
     */
    private Integer grade;

    /**
     * 开始直播时间
     */
    private LocalDateTime startTime;

    /**
     * 直播结束时间
     */
    private LocalDateTime endTime;

    /**
     * 章节及课程时介绍
     */
    private String description;

    /**
     * 时长，单位时:分:秒
     */
    private String timelength;

    /**
     * 排序字段
     */
    private Integer orderby;

    /**
     * 是否支持试学或预览（试看）
     */
    private String isPreview;

    private Long mId;

    /**
     * 媒资文件id
     */
    private String mediaId;

    /**
     * 媒资文件原始名称
     */
    private String mediaFilename;

    private List<CoursePlanTreeDto> coursePlanTreeDto=new ArrayList<>();
}
