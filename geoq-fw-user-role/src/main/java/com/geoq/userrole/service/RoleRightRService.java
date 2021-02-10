package com.geoq.userrole.service;

import com.geoq.userrole.pojo.RoleRightRPojo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleRightRService {
    List<RoleRightRPojo> all_record();

    PageInfo<RoleRightRPojo> part_record(int start, int size);

    RoleRightRPojo select_by_uuid(String uuid);

    String create_role_right_r(RoleRightRPojo pojo);

    String update_role_right_r(RoleRightRPojo pojo);

    String delete_role_right_r(String uuid);
}
