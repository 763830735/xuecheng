package com.ysmdz.model.dto;

import com.ysmdz.model.po.CourseCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CourseCategoryTreeDto extends CourseCategory implements Serializable {
    private String id;

    private String name;

    private String label;

    private String parentid;

    private Integer isShow;

    private Integer orderby;

    private Integer isLeaf;

    private List<CourseCategoryTreeDto> childrenTreeNodes=new ArrayList<>();
}
