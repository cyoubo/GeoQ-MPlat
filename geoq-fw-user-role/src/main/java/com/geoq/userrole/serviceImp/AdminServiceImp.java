package com.geoq.userrole.serviceImp;

import cn.hutool.core.util.StrUtil;
import com.geoq.userrole.component.CommonEnum;
import com.geoq.userrole.mapper.RoleRightRPojoMapper;
import com.geoq.userrole.mapper.UserPojoMapper;
import com.geoq.userrole.pojo.UserPojo;
import com.geoq.userrole.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Slf4j
public class AdminServiceImp implements AdminService {


    @Resource
    private RoleRightRPojoMapper roleRightRPojoMapper;

    @Resource
    private UserPojoMapper userPojoMapper;


    @Override
    public Map<String,Object> query_role_right_code(String uuid) {
        return roleRightRPojoMapper.query_role_right_code(uuid);
    }

    @Override
    public boolean login(String name, String password, Map<String,Object> result) {
        //非空检验
        if(StrUtil.hasEmpty(password,name)) {
            result.put(CommonEnum.MapKey_Reason.name(),"用户名或密码为空");
        }
        else {
            //用户名密码能否找到对应的内容
            UserPojo temp = userPojoMapper.selectByNameAndPassWord(name, password);
            if (temp == null) {
                //判断市用户名是否存在
                result.put(CommonEnum.MapKey_Reason.name(),
                        userPojoMapper.countByName(name) >= 1 ? "密码错误" : "用户不存在");
            } else {
                //获取登录详情
                log.info(temp.getUuid());
                result.putAll(userPojoMapper.selectLoginDetail(temp.getUuid()));
            }
        }
        return result.containsKey(CommonEnum.MapKey_Reason.name()) == false;
    }
}
