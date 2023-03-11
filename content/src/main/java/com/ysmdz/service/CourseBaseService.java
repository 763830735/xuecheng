package com.ysmdz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.ysmdz.mapper.CourseBaseMapper;
import com.ysmdz.mapper.CourseMarketMapper;
import com.ysmdz.model.dto.CourseBaseDTO;
import com.ysmdz.model.dto.UpdateCourseDto;
import com.ysmdz.model.po.CourseBase;
import com.ysmdz.model.po.CourseMarket;
import com.ysmdz.model.vo.NewCourseVo;
import com.ysmdz.model.vo.QueryCourseParamsVo;
import com.ysmdz.util.BeanCopyUtils;
import com.ysmdz.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private CourseMarketMapper courseMarketMapper;

    /*
    更具筛选条件分页查询课程
     */
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

    /*
    新增课程，需要增加course base表，再用主键id插入course market表
    需要添加事务
     */
    @Transactional
    public boolean addCourse(NewCourseVo newCourseVo){
        CourseBase courseBase = BeanCopyUtils.copyObject(newCourseVo, CourseBase.class);
        //默认 未提交
        courseBase.setAuditStatus("202002");
        //默认 未发布
        courseBase.setStatus("203001");
        courseBaseMapper.insert(courseBase);
        CourseMarket courseMarket = BeanCopyUtils.copyObject(newCourseVo, CourseMarket.class);
        courseMarket.setId(courseBase.getId());
        courseMarketMapper.insert(courseMarket);
        return true;
    }

    /*
    根据id查询某一个课程
     */
    public List<UpdateCourseDto> oneCourseBase(Long id){
        return courseBaseMapper.oneCourseBaseWithMarket(id);
    }
}
