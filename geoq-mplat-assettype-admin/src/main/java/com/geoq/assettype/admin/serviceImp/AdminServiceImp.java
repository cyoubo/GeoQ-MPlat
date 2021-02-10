package com.geoq.assettype.admin.serviceImp;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.geoq.assettype.admin.config.AssetTypeTreeNodeConfig;
import com.geoq.assettype.admin.mapper.AssetTypePojoMapper;
import com.geoq.assettype.admin.pojo.AssetTypePojo;
import com.geoq.assettype.admin.service.AdminService;
import com.geoq.common.entry.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AdminServiceImp implements AdminService {

    @Resource
    private AssetTypePojoMapper mapper;

    @Resource
    private TreeNodeConfig treeNodeConfig;

    @Override
    public List<AssetTypePojo> all_record() {
        return mapper.select_all();
    }

    @Override
    public String create_asset_type(AssetTypePojo pojo) {
        String result = "";
        try
        {
            pojo.setUuid(UUID.fastUUID().toString());
            //依据uuid溯源，生成code
            
            result = CommonUtils.successMsgTemplate(pojo.getUuid());
        }
        catch (Exception ex){
            log.error("create_asset_type",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String update_asset_type(AssetTypePojo pojo) {
        String result = "";
        try {
            int affect = mapper.updateByPrimaryKeySelective(pojo);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("update_asset_type",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public AssetTypePojo select_by_uuid(String uuid) {
        return mapper.selectByPrimaryKey(uuid);
    }

    @Override
    public String delete_by_uuid(String uuid) {
        String result = "";
        try
        {
            //数据表里定义了自外键，删除指定uuid的数据后，会将下属记录同时删除
            int affect = mapper.deleteByPrimaryKey(uuid);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("delete_by_uuid",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }
}
