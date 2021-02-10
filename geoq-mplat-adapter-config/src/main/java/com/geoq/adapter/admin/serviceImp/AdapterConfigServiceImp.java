package com.geoq.adapter.admin.serviceImp;


import cn.hutool.core.lang.UUID;
import com.geoq.adapter.admin.mapper.AdapterPojoMapper;
import com.geoq.adapter.admin.pojo.AdapterPojo;
import com.geoq.common.entry.CommonUtils;
import com.geoq.mplat.component.dataadapter.AdapterContextFactory;
import com.geoq.adapter.admin.service.AdapterConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AdapterConfigServiceImp implements AdapterConfigService {

    @Resource
    private AdapterContextFactory adapterContextFactory;

    @Resource
    private AdapterPojoMapper mapper;

    @Override
    public List<AdapterPojo> all_record() {
        return mapper.select_all();
    }

    @Override
    public PageInfo<AdapterPojo> part_record(int start, int size) {
        PageHelper.startPage(start,size);
        return new PageInfo<AdapterPojo>(mapper.select_all());
    }

    @Override
    public String create_adapter_config(String type, String name, String des, String objstr) {

        StringBuilder msg = new StringBuilder();
        if(!OnValidateTypeAndObjStr(type,objstr,msg))
            return msg.toString();

        AdapterPojo pojo = new AdapterPojo();
        pojo.setAdapterType(type);
        pojo.setAdapterName(name);
        pojo.setAdapterDescription(des);
        pojo.setAdapterContext(objstr);
        pojo.setUuid(UUID.fastUUID().toString());
        try
        {
            mapper.insert(pojo);
            msg.append(CommonUtils.successMsgTemplate(pojo.getUuid()));
        }
        catch (Exception ex)
        {
            log.error("create_adapter_config",ex);
            msg.append(CommonUtils.errorMsgTemplate(ex.getMessage()));
        }
        return msg.toString();
    }

    @Override
    public AdapterPojo select_by_uuid(String uuid) {
        return mapper.selectByPrimaryKey(uuid);
    }

    @Override
    public String update_adapter_config(String uuid, String type, String name, String description, String objstr) {

        StringBuilder msg = new StringBuilder();
        if(!OnValidateTypeAndObjStr(type,objstr,msg))
            return msg.toString();
        AdapterPojo pojo = new AdapterPojo();
        pojo.setAdapterType(type);
        pojo.setAdapterName(name);
        pojo.setAdapterDescription(description);
        pojo.setAdapterContext(objstr);
        pojo.setUuid(uuid);
        String result = "";
        try {
            int affect = mapper.updateByPrimaryKeySelective(pojo);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("update_adapter_config",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String delete_adapter_config(String[] uuids) {
        String result = "";
        try {
            int affect = mapper.deleteByPrimaryKeys(uuids);
            result = CommonUtils.successMsgTemplate(CommonUtils.affectRowTemplate(affect));
        }
        catch (Exception ex){
            log.error("delete_adapter_config",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }

    private boolean OnValidateTypeAndObjStr(String type, String objstr, StringBuilder builder)
    {
        AdapterContextFactory.AdapterContextEnum typeEnum = adapterContextFactory.checkType(type);
        if(typeEnum == AdapterContextFactory.AdapterContextEnum.Unknow)
        {
            builder.append(CommonUtils.failMsgTemplate(String.format("%s -- 不能解析的Context类型 %s",objstr,type)));
            log.info(builder.toString());
            return false;
        }

        if(!adapterContextFactory.create(typeEnum).validateContextString(objstr))
        {
            builder.append(CommonUtils.failMsgTemplate(String.format("%s -- 不满足 %s 的格式需求",objstr,typeEnum.name())));
            log.info(builder.toString());
            return false;
        }
        return true;
    }
}
