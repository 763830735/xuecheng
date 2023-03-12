package com.ysmdz.fun;

import com.ysmdz.mapper.TeachplanMediaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class TeachplanMediaService {
    @Autowired
    private TeachplanMediaMapper teachplanMediaMapper;
    public void insertMedia(Map<String,String> map){
        teachplanMediaMapper.insertMedia(map);
    }
}
