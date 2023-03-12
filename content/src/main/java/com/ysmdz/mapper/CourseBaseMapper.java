package com.ysmdz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysmdz.model.po.CourseBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    List<Map<String, Object>> queryCourse(@Param("companyId") Long companyId, @Param("name") String name,
                                          @Param("auditStatus") String auditStatus,@Param("status") String status,
                                          @Param("current") long current,@Param("pageSize") long pageSize);
}
