package com.geoq.userrole.mapper;


import com.geoq.userrole.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface UserPojoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);

    int count_by_department_uuid(String uuid);

    List<UserPojo> select_all();

    List<UserPojo> select_all_decorate();

    int deleteByPrimaryKeys(String[] uuids);

    UserPojo selectByNameAndPassWord(@Param("name") String name, @Param("password") String password);

    int countByName(String name);

    /***
     * 查询指定用户uuid的登录详情
     * @param uuid
     * @return 用户名，部门中文，角色中文，权限列表
     */
    Map<String,Object> selectLoginDetail(@Param("uuid") String uuid);
}