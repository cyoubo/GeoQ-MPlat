package com.geoq.userrole.serviceImp;

import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.mapper.DepartmentPojoMapper;
import com.geoq.userrole.mapper.UserPojoMapper;
import com.geoq.userrole.pojo.DepartmentPojo;
import com.geoq.userrole.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class DepartmentServiceImp implements DepartmentService {

    @Resource
    private UserPojoMapper userMapper;

    @Resource
    private DepartmentPojoMapper departmentMapper;

    @Override
    public PageInfo part_record(int start, int size) {
        PageHelper.startPage(start,size);
        List<DepartmentPojo> temp_list = departmentMapper.select_all();
        return new PageInfo<>(temp_list);
    }

    @Override
    public List<DepartmentPojo> all_record() {
        return departmentMapper.select_all();
    }

    @Override
    public DepartmentPojo select_by_uuid(String uuid) {
        return departmentMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public String create_department(DepartmentPojo pojo) {
        String result = "";
        try
        {
            pojo.setUuid(UUID.randomUUID().toString());
            departmentMapper.insert(pojo);
            result = CommonUtils.successMsgTemplate(pojo.getUuid());
        }
        catch (Exception ex)
        {
            log.error("create_department",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String update_department(DepartmentPojo pojo) {
        String result = "";
        try
        {
            int affect = departmentMapper.updateByPrimaryKeySelective(pojo);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex)
        {
            log.error("update_department",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String delete_department(String uuid) {
        if(userMapper.count_by_department_uuid(uuid) >0 ) {
            return CommonUtils.failMsgTemplate("当前部门还存在人员信息,请删除后重试...");
        }
        String result = "";
        try
        {
            int affect = departmentMapper.deleteByPrimaryKey(uuid);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex)
        {
            log.error("delete_department",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }


}
