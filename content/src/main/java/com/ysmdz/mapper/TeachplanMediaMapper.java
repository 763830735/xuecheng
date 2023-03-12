package com.ysmdz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysmdz.model.po.TeachplanMedia;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author itcast
 */
@Mapper
public interface TeachplanMediaMapper extends BaseMapper<TeachplanMedia> {
    void insertMedia(Map<String,String> map);
}
