package com.geoq.assettype.admin.serviceImp;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.NumberUtil;
import com.geoq.assettype.admin.config.AssetTypeTreeNodeConfig;
import com.geoq.assettype.admin.mapper.AssetTypePojoMapper;
import com.geoq.assettype.admin.pojo.AssetTypePojo;
import com.geoq.assettype.admin.service.AdminService;
import com.geoq.common.datastruct.AdjacencyTable;
import com.geoq.common.datastruct.AdjacencyTableElement;
import com.geoq.common.entry.CommonUtils;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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
            if(NumberUtil.isInteger(mapper.selectByPrimaryKey(pojo.getUuid()).getCode()))
            {
                List<AssetTypePojo> brother_nodes = mapper.selectByParentUUID(pojo.getParentUuid());
                AssetTypePojo tempNode = brother_nodes.stream().max((a, b)->Integer.parseInt(a.getCode()) - Integer.parseInt(b.getCode())).get();
                pojo.setCode(String.format("%2d",Integer.parseInt(tempNode.getCode())+1));
            }
            result = CommonUtils.successMsgTemplate(pojo.getUuid());
        }
        catch (NumberFormatException ex)
        {
            log.error("create_asset_type",ex);
            result = CommonUtils.errorMsgTemplate("不能创建一级类别...");
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

    @Override
    public String generate_asset_type_code(String uuid) {
        AssetTypePojo current_pojo = mapper.selectByPrimaryKey(uuid);
        AdjacencyTable table = new AdjacencyTable();
        table.loadData(mapper.select_all());
        for (AdjacencyTableElement element : table.trackBack2root(current_pojo)) {
            log.info(((AssetTypePojo)(element)).getCode());
        }
        table.release();
        return "";
    }
}
