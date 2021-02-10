package com.geoq.mplat.component.dataadapter;

import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NormalDBAdapterContext extends AbstractAdapterContext {
    private String DB_Type;
    private String Host;
    private String Port;
    private String Username;
    private String Password;
    private Map<String,String> OtherParams;

    @Override
    protected boolean onValidateContextString_Context(JSONObject jsonObject) {
        return onValidateEmptyStr(jsonObject,"OtherParams");
    }

    @Override
    protected boolean onValidateContextString_Field(JSONObject jsonObject, Field[] fields) {
        return onValidateFieldsExist(jsonObject,fields,"OtherParams");
    }
}
