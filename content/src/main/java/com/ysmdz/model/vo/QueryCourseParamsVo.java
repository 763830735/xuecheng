package com.ysmdz.model.vo;

import lombok.Data;

@Data
public class QueryCourseParamsVo {
    //审核状态
    private String auditStatus;
    //课程名
    private String courseName;
    //发布状态
    private String publishStatus;
}
