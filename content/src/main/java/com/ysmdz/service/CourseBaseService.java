package com.ysmdz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.ysmdz.mapper.CourseBaseMapper;
import com.ysmdz.model.dto.CourseBaseDTO;
import com.ysmdz.model.po.CourseBase;
import com.ysmdz.model.vo.QueryCourseParamsVo;
import com.ysmdz.util.BeanCopyUtils;
import com.ysmdz.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程基本信息 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class CourseBaseService {
    @Autowired
    private CourseBaseMapper courseBaseMapper;

    public List<CourseBaseDTO> listCourseBase(QueryCourseParamsVo queryCourseParamsVo) {
        LambdaQueryWrapper<CourseBase> queryWrapper=new LambdaQueryWrapper<>();
        //机构名
        queryWrapper.eq(CourseBase::getCompanyId,queryCourseParamsVo.getCompanyId());
        //课程名
        queryWrapper.like(!StringUtils.isNullOrEmpty(queryCourseParamsVo.getCourseName()),CourseBase::getName,queryCourseParamsVo.getCourseName());
        //审核状态
        queryWrapper.eq(!StringUtils.isNullOrEmpty(queryCourseParamsVo.getAuditStatus()),CourseBase::getAuditStatus,queryCourseParamsVo.getAuditStatus());
        //发布状态
        queryWrapper.eq(!StringUtils.isNullOrEmpty(queryCourseParamsVo.getPublishStatus()),CourseBase::getStatus,queryCourseParamsVo.getPublishStatus());

        Page<CourseBase> page=new Page<>(PageUtils.getCurrent(),PageUtils.getSize());
        courseBaseMapper.selectPage(page, queryWrapper);
        return BeanCopyUtils.copyList(page.getRecords(), CourseBaseDTO.class);
    }
}
