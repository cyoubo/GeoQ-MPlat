package com.geoq.userrole.mapper;


import com.geoq.userrole.pojo.RolePojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RolePojoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RolePojo record);

    int insertSelective(RolePojo record);

    RolePojo selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RolePojo record);

    int updateByPrimaryKey(RolePojo record);

    List<RolePojo> select_all();
}