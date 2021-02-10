package com.geoq.adapter.admin.service;

import com.geoq.adapter.admin.pojo.AdapterPojo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdapterConfigService {

    List<AdapterPojo> all_record();

    PageInfo<AdapterPojo> part_record(int start, int size);

    String create_adapter_config(String type, String name, String des, String objstr);

    AdapterPojo select_by_uuid(String uuid);

    String update_adapter_config(String uuid, String type, String name, String description, String objstr);

    String delete_adapter_config(String[] uuids);
}
