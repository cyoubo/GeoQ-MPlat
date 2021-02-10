package com.geoq.adapter.admin.mapper;

import com.geoq.adapter.admin.pojo.AdapterPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AdapterPojoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(AdapterPojo record);

    int insertSelective(AdapterPojo record);

    AdapterPojo selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(AdapterPojo record);

    int updateByPrimaryKey(AdapterPojo record);

    List<AdapterPojo> select_all();

    int deleteByPrimaryKeys(String[] uuids);
}