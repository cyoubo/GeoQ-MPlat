package com.geoq.common.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private int status;

    private String message;

    private T data;

    public CommonResult(int status, String message)
    {
        this(status,message,null);
    }

    public void ok(String message, T data) {
        this.status = 200;
        this.message = message;
        this.data = data;
    }

    public void  error(String message, T data)
    {
        this.status = 500;
        this.message = message;
        this.data = data;
    }

    public void ok_str(String data)
    {
        this.status = 200;
        this.data = (T)data.substring(data.indexOf("]--") + 3);
        this.message = CommonUtils.ResponseTag_Success;

        if(data.startsWith(CommonUtils.ResponseTag_Fail))
        {
            this.message = CommonUtils.ResponseTag_Fail;
            this.status = 500;
        }

        if(data.startsWith(CommonUtils.ResponseTag_Error))
        {
            this.message = CommonUtils.ResponseTag_Error;
            this.status = 500;
        }
    }



}
