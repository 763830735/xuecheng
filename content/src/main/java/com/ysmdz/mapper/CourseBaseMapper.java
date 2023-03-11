package com.ysmdz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysmdz.model.dto.UpdateCourseDto;
import com.ysmdz.model.po.CourseBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程基本信息 Mapper 接口
 * </p>
 *
 * @author itcast
 */
@Mapper
public interface CourseBaseMapper extends BaseMapper<CourseBase> {
    List<UpdateCourseDto> oneCourseBaseWithMarket(Long id);
}
