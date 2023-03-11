package com.ysmdz.service;

import com.ysmdz.mapper.TeachplanMapper;
import com.ysmdz.model.dto.CoursePlanTreeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 课程计划 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class TeachplanService {
    @Autowired
    private TeachplanMapper teachplanMapper;

    public List<CoursePlanTreeDto> oneTeachPlan(Long id){
        List<CoursePlanTreeDto> coursePlanTreeDtos = teachplanMapper.oneTeachplan(id);
        //父节点是0L
        List<CoursePlanTreeDto> coursePlanTreeDtos1 = teachplanTree(coursePlanTreeDtos, 0L);
        return coursePlanTreeDtos1;
    }

    /**
     *获取父节点的所有子节点
     */
    public List<CoursePlanTreeDto> teachplanTree(List<CoursePlanTreeDto> list,Long parentId){
        List<CoursePlanTreeDto> list1=new ArrayList<>();
        for (int i=0;i<list.size();++i){
            if (Objects.equals(list.get(i).getParentid(), parentId)){
                List<CoursePlanTreeDto> coursePlanTreeDtos = teachplanTree(list, list.get(i).getId());
                list.get(i).getCoursePlanTreeDto().addAll(coursePlanTreeDtos);
                list1.add(list.get(i));
            }
        }
        return list1;
    }
}
