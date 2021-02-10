package com.geoq.userrole.service;

import com.geoq.userrole.pojo.RoleRightPojo;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface RoleRightService {
    String delete_role_right(String uuid);

    String update_role_right(RoleRightPojo pojo);

    String create_role_right(RoleRightPojo pojo);

    RoleRightPojo select_by_uuid(String uuid);

    PageInfo<RoleRightPojo> part_record(int start, int size);

    List<RoleRightPojo> all_record();
}
