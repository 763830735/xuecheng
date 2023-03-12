package com.ysmdz.fun;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ysmdz.mapper.CourseCategoryMapper;
import com.ysmdz.model.po.CourseCategory;
import com.ysmdz.util.BeanCopyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 课程分类 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class CourseCategoryService {
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;
}
