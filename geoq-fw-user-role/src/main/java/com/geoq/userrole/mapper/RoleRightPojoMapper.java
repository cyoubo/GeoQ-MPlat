package com.geoq.userrole.mapper;

import com.geoq.userrole.pojo.RoleRightPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleRightPojoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RoleRightPojo record);

    int insertSelective(RoleRightPojo record);

    RoleRightPojo selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RoleRightPojo record);

    int updateByPrimaryKey(RoleRightPojo record);

    List<RoleRightPojo> select_all();
}