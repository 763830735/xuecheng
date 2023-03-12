package com.ysmdz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysmdz.model.po.Teachplan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程计划 Mapper 接口
 * </p>
 *
 * @author itcast
 */
@Mapper
public interface TeachplanMapper extends BaseMapper<Teachplan> {
    List<Map<String,Object>> queryAllTeachplan(Long id);
    void insertTeachPlan(Map<String,String> map);
}
