package com.geoq.userrole.mapper;


import com.geoq.userrole.pojo.RoleRightRPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface RoleRightRPojoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RoleRightRPojo record);

    int insertSelective(RoleRightRPojo record);

    RoleRightRPojo selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RoleRightRPojo record);

    int updateByPrimaryKey(RoleRightRPojo record);

    List<RoleRightRPojo> select_all();

    Map<String,Object> query_role_right_code(String uuid);
}