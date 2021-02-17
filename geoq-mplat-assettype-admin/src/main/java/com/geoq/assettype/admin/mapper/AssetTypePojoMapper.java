package com.geoq.assettype.admin.mapper;

import com.geoq.assettype.admin.pojo.AssetTypePojo;
import com.geoq.common.datastruct.AdjacencyTableElement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AssetTypePojoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(AssetTypePojo record);

    int insertSelective(AssetTypePojo record);

    AssetTypePojo selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(AssetTypePojo record);

    int updateByPrimaryKey(AssetTypePojo record);

    List<AssetTypePojo> select_all();

    List<AssetTypePojo> selectByParentUUID(String parentUuid);
}