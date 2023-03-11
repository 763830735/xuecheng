package com.ysmdz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ysmdz.mapper.CourseCategoryMapper;
import com.ysmdz.model.dto.CourseCategoryTreeDto;
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

    public List<CourseCategoryTreeDto> getCourseCategory(){
        LambdaQueryWrapper<CourseCategory> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CourseCategory::getIsShow,1);
        List<CourseCategory> courseCategories = courseCategoryMapper.selectList(lambdaQueryWrapper);
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = treeSort(courseCategories, "1");
        return courseCategoryTreeDtos;
    }

    //parentid为parent的子树
    public List<CourseCategoryTreeDto> treeSort(List<CourseCategory> list,String parent){
        ArrayList<CourseCategoryTreeDto> courseCategoryTreeDtos=new ArrayList<>();
        for (int i=0;i<list.size();++i){
            if (list.get(i).getParentid().equals(parent)){
                CourseCategoryTreeDto courseCategoryTreeDto = BeanCopyUtils.copyObject(list.get(i), CourseCategoryTreeDto.class);
                courseCategoryTreeDto.getChildrenTreeNodes().addAll(treeSort(list,courseCategoryTreeDto.getId()));
                courseCategoryTreeDtos.add(courseCategoryTreeDto);
            }
        }
        courseCategoryTreeDtos.sort(Comparator.comparingInt(CourseCategoryTreeDto::getOrderby));
        return courseCategoryTreeDtos;
    }
}
