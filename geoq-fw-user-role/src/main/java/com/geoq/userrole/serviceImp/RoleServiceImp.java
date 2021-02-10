package com.geoq.userrole.serviceImp;

import cn.hutool.core.lang.UUID;
import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.mapper.RolePojoMapper;
import com.geoq.userrole.pojo.RolePojo;
import com.geoq.userrole.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImp implements RoleService {

    @Resource
    private RolePojoMapper rolePojoMapper;

    @Override
    public String delete_role(String uuid) {
        String result = "";
        try
        {
            int affect = rolePojoMapper.deleteByPrimaryKey(uuid);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("delete_role",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String update_role(RolePojo pojo) {

        String result = "";
        try {
            int affect = rolePojoMapper.updateByPrimaryKeySelective(pojo);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("update_role",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String create_role(RolePojo pojo) {
        String result = "";
        try {
            pojo.setUuid(UUID.fastUUID().toString());
            rolePojoMapper.insert(pojo);
            result = CommonUtils.successMsgTemplate(pojo.getUuid());
        }
        catch (Exception ex){
            log.error("create_role",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public RolePojo select_by_uuid(String uuid) {
        return rolePojoMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public PageInfo<RolePojo> part_record(String token, int start, int size) {
        PageHelper.startPage(start,size);
        List<RolePojo> temp_list = rolePojoMapper.select_all();
        return new PageInfo<>(temp_list);
    }

    @Override
    public List<RolePojo> all_record(String token) {
        return rolePojoMapper.select_all();
    }
}
