package com.ysmdz.fun;

import com.ysmdz.mapper.CourseBaseMapper;
import com.ysmdz.mapper.CourseMarketMapper;
import com.ysmdz.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    根据筛选条件分页查询课程
     */
    public List<Map<String,Object>> queryCourse(Map<String, String> map) {
        List<Map<String, Object>> course = courseBaseMapper.queryCourse(Long.parseLong(map.get("companyId")),map.get("name"),
                map.get("auditStatus"),map.get("status"),
                PageUtils.getCurrent(),PageUtils.getSize());
        return course;
    }

}
