package com.geoq.userrole.serviceImp;

import cn.hutool.core.lang.UUID;
import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.mapper.RoleRightPojoMapper;
import com.geoq.userrole.pojo.RoleRightPojo;
import com.geoq.userrole.service.RoleRightService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class RoleRightServiceImp implements RoleRightService {

    @Resource
    private RoleRightPojoMapper roleRightPojoMapper;

    @Override
    public String delete_role_right(String uuid) {
        String result = "";
        try {
            int affect = roleRightPojoMapper.deleteByPrimaryKey(uuid);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("delete_role_right",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String update_role_right(RoleRightPojo pojo) {
        String result = "";
        try {
            int affect = roleRightPojoMapper.updateByPrimaryKeySelective(pojo);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("update_role_right",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String create_role_right(RoleRightPojo pojo) {
        String result = "";
        try {
            pojo.setUuid(UUID.fastUUID().toString());
            result = CommonUtils.successMsgTemplate(pojo.getUuid());
        }
        catch (Exception ex){
            log.error("create_role_right",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public RoleRightPojo select_by_uuid(String uuid) {
        return roleRightPojoMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public PageInfo<RoleRightPojo> part_record(int start, int size) {
        PageHelper.startPage(start,size);
        return new PageInfo<>(roleRightPojoMapper.select_all());
    }

    @Override
    public List<RoleRightPojo> all_record() {
        return roleRightPojoMapper.select_all();
    }
}
