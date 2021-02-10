package com.geoq.userrole.mapper;


import com.geoq.userrole.pojo.DepartmentPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DepartmentPojoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(DepartmentPojo record);

    int insertSelective(DepartmentPojo record);

    DepartmentPojo selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(DepartmentPojo record);

    int updateByPrimaryKey(DepartmentPojo record);

    List<DepartmentPojo> select_all();
}