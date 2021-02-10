package com.geoq.mplat.component.dataadapter;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.lang.reflect.Field;
import java.util.Map;

public abstract class AbstractAdapterContext {

    protected abstract boolean onValidateContextString_Context(JSONObject jsonObject);

    protected abstract boolean onValidateContextString_Field(JSONObject jsonObject, Field[] fields);

    /**
     * 验证字符串是否满足对应类型的字段需求
     * @param objstr
     * @return
     */
    public boolean validateContextString(String objstr)
    {
        JSONObject jsonObject = JSONUtil.parseObj(objstr);
        Field[] fields =  ReflectUtil.getFields(this.getClass());
        if(onValidateContextString_Field(jsonObject,fields))
        {
            return onValidateContextString_Context(jsonObject);
        }
        return false;
    }

    /**
     * 检验当前对象中是否有空值
     * @param jsonObject 当前对象
     * @param nullableFields 可空的属性名
     * @return 除可空属性名外，其他属性都非空则返回true，否则返回false
     */
    protected boolean onValidateEmptyStr(JSONObject jsonObject, String... nullableFields)
    {
        boolean result = true;
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            if(nullableFields == null || nullableFields!=null && !ArrayUtil.contains(nullableFields,entry.getKey()))
                result = !StrUtil.isEmpty(entry.getValue().toString()) & result;
            if(!result)
                break;
        }
        return result;
    }

    /**
     * 检验当前对象是否有属性缺失
     * @param jsonObject 当前对象
     * @param fields 当前对象的字段属性
     * @param nullableFields 可缺失字段名
     * @return 除可缺失属性名外，其他属性字段都存在则返回true，否则返回false
     */
    protected boolean onValidateFieldsExist(JSONObject jsonObject, Field[] fields, String... nullableFields) {
        boolean result = true;
        for (Field field : fields) {
            if(nullableFields==null || nullableFields!=null && !ArrayUtil.contains(nullableFields,field.getName()))
                result = jsonObject.containsKey(field.getName()) & result;
            if(!result)
                break;
        }
        return result;
    }
}
