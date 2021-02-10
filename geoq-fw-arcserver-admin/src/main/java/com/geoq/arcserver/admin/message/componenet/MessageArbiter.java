package com.geoq.arcserver.admin.message.componenet;

import com.geoq.arcserver.admin.message.element.Error;

public class MessageArbiter {

    public enum BaseMessageState
    {
        error,
        success,
        fail,
        unknown
    }

    public BaseMessageState arbitrateState(Error error)
    {
        if(error == null || error.getCode() == 200 || error.getCode() == 0)
            return BaseMessageState.success;
        else if(error.getCode()== 500)
            return BaseMessageState.error;
        else
            return BaseMessageState.unknown;
    }
}
