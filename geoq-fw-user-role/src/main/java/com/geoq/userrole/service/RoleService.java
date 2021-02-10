package com.geoq.userrole.service;


import com.geoq.userrole.pojo.RolePojo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {
    String delete_role(String uuid);

    String update_role(RolePojo pojo);

    String create_role(RolePojo pojo);

    RolePojo select_by_uuid(String uuid);

    PageInfo<RolePojo> part_record(String token, int start, int size);

    List<RolePojo> all_record(String token);
}
