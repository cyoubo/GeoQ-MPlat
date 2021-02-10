package com.geoq.userrole.serviceImp;

import cn.hutool.core.lang.UUID;
import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.mapper.RoleRightRPojoMapper;
import com.geoq.userrole.pojo.RoleRightRPojo;
import com.geoq.userrole.service.RoleRightRService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class RoleRightRServiceImp implements RoleRightRService {

    @Resource
    private RoleRightRPojoMapper roleRightRPojoMapper;

    @Override
    public List<RoleRightRPojo> all_record() {
        return roleRightRPojoMapper.select_all();
    }

    @Override
    public PageInfo<RoleRightRPojo> part_record(int start, int size) {
        PageHelper.startPage(start,size);
        return new PageInfo<RoleRightRPojo>(roleRightRPojoMapper.select_all());
    }

    @Override
    public RoleRightRPojo select_by_uuid(String uuid) {
        return roleRightRPojoMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public String create_role_right_r(RoleRightRPojo pojo) {
        String result = "";
        try {
            pojo.setUuid(UUID.fastUUID().toString());
            result = CommonUtils.successMsgTemplate(pojo.getUuid());
        }
        catch (Exception ex){
            log.error("create_role_right_r",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String update_role_right_r(RoleRightRPojo pojo) {
        String result = "";
        try {
            int affect = roleRightRPojoMapper.updateByPrimaryKeySelective(pojo);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("update_role_right_r",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String delete_role_right_r(String uuid) {
        String result = "";
        try {
            int affect = roleRightRPojoMapper.deleteByPrimaryKey(uuid);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("delete_role_right_r",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;

    }
}
