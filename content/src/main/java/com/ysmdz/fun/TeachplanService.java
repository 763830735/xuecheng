package com.ysmdz.fun;

import com.ysmdz.mapper.TeachplanMapper;
import com.ysmdz.mapper.TeachplanMediaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Autowired
    private TeachplanMediaMapper teachplanMediaMapper;

    public List<Map<String,Object>> queryAllTeachplan(Long id){
        List<Map<String, Object>> maps = teachplanMapper.queryAllTeachplan(id);
        //父节点是0L
        return teachplanTree(maps, 0L);
    }

    /**
     *获取父节点的所有子节点 形成树
     */
    public List<Map<String,Object>> teachplanTree(List<Map<String,Object>> list,Long parentId){
        List<Map<String,Object>> list1=new ArrayList<>();
        for (int i=0;i<list.size();++i){
            if (Objects.equals(list.get(i).get("parentid"), parentId)){
                List<Map<String, Object>> id = teachplanTree(list, (Long) list.get(i).get("id"));
                list.get(i).put("children",id);
                list1.add(list.get(i));
            }
        }
        list1.sort(Comparator.comparingInt(o -> (int) o.get("orderby")));
        return list1;
    }

    @Transactional
    public Map<String,Object> insertTeachPlan(Map<String,String> map){
        // TODO: 2023/3/13 首先要判断orderby是否重复
        teachplanMapper.insertTeachPlan(map);
        map.put("teachplanId",String.valueOf(map.get("id")));
        teachplanMediaMapper.insertMedia(map);
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("id",map.get("teachplanId"));
        returnMap.put("mediaId",map.get("id"));
        return returnMap;
    }
}
