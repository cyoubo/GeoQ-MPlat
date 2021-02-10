package com.geoq.userrole.serviceImp;

import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.component.TokenValidator;
import com.geoq.userrole.mapper.UserPojoMapper;
import com.geoq.userrole.pojo.UserPojo;
import com.geoq.userrole.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Resource
    private UserPojoMapper userMapper;

    @Resource
    private TokenValidator validator;

    @Override
    public List<UserPojo> all_record(String token) {
        switch (validator.validate_token(token))
        {
            case admin: return userMapper.select_all();
            default: return userMapper.select_all_decorate();
        }

    }

    @Override
    public PageInfo part_record(String token,int start, int size) {

        List<UserPojo> temp_list = null;
        switch (validator.validate_token(token))
        {
            case admin: {
                PageHelper.startPage(start,size);
                temp_list = userMapper.select_all();
            }
            default: {
                PageHelper.startPage(start,size);
                temp_list = userMapper.select_all_decorate();
            }
        }
        return new PageInfo<>(temp_list);
    }

    @Override
    public UserPojo select_by_uuid(String uuid) {
        return userMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public String create_user(UserPojo pojo) {
        String result = "";
        try {
            pojo.setUuid(UUID.randomUUID().toString());
            userMapper.insert(pojo);
            result = CommonUtils.successMsgTemplate(pojo.getUuid());
        }
        catch (Exception ex){
            log.error("create_user",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String update_user(UserPojo pojo) {
        String result = "";
        try {
            int affect = userMapper.updateByPrimaryKeySelective(pojo);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("update_user",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;

    }

    @Override
    public String delete_user(String[] uuids) {
        String result = "";
        try {
            int affect = userMapper.deleteByPrimaryKeys(uuids);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("delete_user",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }




}
