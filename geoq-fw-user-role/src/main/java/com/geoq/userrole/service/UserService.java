package com.geoq.userrole.service;

import com.geoq.userrole.pojo.UserPojo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    List<UserPojo> all_record(String token);

    UserPojo select_by_uuid(String uuid);

    String create_user(UserPojo pojo);

    String update_user(UserPojo pojo);

    String delete_user(String[] uuids);

    PageInfo part_record(String token, int start, int size);


}
