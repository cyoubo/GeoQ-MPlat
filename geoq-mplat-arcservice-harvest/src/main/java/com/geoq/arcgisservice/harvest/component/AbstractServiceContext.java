package com.geoq.arcgisservice.harvest.component;

public abstract class AbstractServiceContext {

    public abstract String toJson();

    public abstract AbstractServiceContext extract(String temp);
}
