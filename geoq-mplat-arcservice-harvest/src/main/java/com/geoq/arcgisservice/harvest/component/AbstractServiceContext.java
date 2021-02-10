package com.geoq.arcgisservice.harvest.component;

import com.geoq.arcserver.admin.message.BaseMessage;

public abstract class AbstractServiceContext {

    public abstract String toJson();

    public abstract AbstractServiceContext extract(BaseMessage temp);
}
