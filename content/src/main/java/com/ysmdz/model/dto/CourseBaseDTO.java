package com.ysmdz.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseBaseDTO {
    private Long id;
    private String name;
    private String teachmode;
    private String auditStatus;
    private String status;
    private LocalDateTime createDate;
}
