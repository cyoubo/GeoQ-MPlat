package com.geoq.mplat.component.dataadapter;

import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalFoldAdapterContext extends AbstractAdapterContext{
    private String Host;
    private String Username;
    private String Password;
    private String SubFold;

    @Override
    protected boolean onValidateContextString_Context(JSONObject jsonObject) {
        return onValidateEmptyStr(jsonObject, null);
    }

    @Override
    protected boolean onValidateContextString_Field(JSONObject jsonObject, Field[] fields) {
        return onValidateFieldsExist(jsonObject,fields,null);
    }

}
