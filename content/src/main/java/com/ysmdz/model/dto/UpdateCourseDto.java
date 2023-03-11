package com.ysmdz.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateCourseDto {

    /**
     * 主键，课程id
     */
    private Long id;

    private Long companyId;
    private String companyName;
    private String name;
    private String users;
    private String tags;
    private String mt;
    private String st;
    private String grade;
    private String teachmode;
    private String description;
    private String pic;
    private LocalDateTime createDate;
    private LocalDateTime changeDate;
    private String createPeople;
    private String changePeople;
    private String auditStatus;
    private String status;

    /**
     * 收费规则，对应数据字典
     */
    private String charge;
    /**
     * 现价
     */
    private Float price;

    /**
     * 原价
     */
    private Float originalPrice;

    /**
     * 咨询qq
     */
    private String qq;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 电话
     */
    private String phone;

    /**
     * 有效期天数
     */
    private Integer validDays;

}
