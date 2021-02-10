package com.geoq.assettype.admin.service;

import com.geoq.assettype.admin.pojo.AssetTypePojo;

import java.util.List;

public interface AdminService {
    List<AssetTypePojo> all_record();

    String create_asset_type(AssetTypePojo pojo);

    String update_asset_type(AssetTypePojo pojo);

    AssetTypePojo select_by_uuid(String uuid);

    String delete_by_uuid(String uuid);
}
