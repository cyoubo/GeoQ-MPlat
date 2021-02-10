package com.geoq.common.entry;

public class CommonUtils {

    public static final String ResponseTag_Success = "_success";
    public static final String ResponseTag_Fail = "_fail";
    public static final String ResponseTag_Error = "_error";


    public static String failMsgTemplate(String msg)
    {
        return String.format("[%s]--%s",ResponseTag_Fail,msg);
    }

    public static String errorMsgTemplate(String msg)
    {
        return String.format("[%s]--%s",ResponseTag_Error, msg);
    }

    public static String successMsgTemplate(String msg)
    {
        return String.format("[%s]--%s",ResponseTag_Success,msg);
    }

    public static String affectRowTemplate(int rows){
        return String.format("%d rows affected",rows);
    }
}
