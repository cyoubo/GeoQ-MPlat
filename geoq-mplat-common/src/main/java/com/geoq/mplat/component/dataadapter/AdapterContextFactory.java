package com.geoq.mplat.component.dataadapter;

import org.springframework.stereotype.Component;


public class AdapterContextFactory {

    public enum AdapterContextEnum {
        NormalFold,
        NormalDB,
        Unknow
    }

    public AdapterContextEnum checkType(String type) {
        type = type.toUpperCase();
        if(type.contentEquals(AdapterContextEnum.NormalDB.name().toUpperCase()))
            return AdapterContextEnum.NormalDB;
        else if(type.contentEquals(AdapterContextEnum.NormalFold.name().toUpperCase()))
            return AdapterContextEnum.NormalFold;
        else
            return AdapterContextEnum.Unknow;
    }



    /**
     * 依据类型创建常量，创建一个不含任何属性内容的空对象(一般用于检验)
     * @param TypeEnum
     * @return 一个不含任何属性内容的空对象
     */
    public AbstractAdapterContext create(AdapterContextEnum TypeEnum) {
        switch (TypeEnum) {
            case NormalDB: return new NormalDBAdapterContext();
            case NormalFold:return new NormalFoldAdapterContext();
            default:return null;
        }
    }
}
