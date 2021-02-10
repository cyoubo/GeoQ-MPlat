package com.geoq.userrole.service;

import com.geoq.userrole.pojo.DepartmentPojo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DepartmentService {

    PageInfo part_record(int start, int size);

    DepartmentPojo select_by_uuid(String uuid);

    String create_department(DepartmentPojo pojo);

    String update_department(DepartmentPojo pojo);

    String delete_department(String uuids);

    List<DepartmentPojo> all_record();
}
