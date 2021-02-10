package com.geoq.arcserver.admin.message.componenet;

import com.geoq.arcserver.admin.message.*;


public class MessageFactory {

    public static BaseMessage create(String TypeStr)
    {
        TypeStr = TypeStr.toLowerCase();
        switch (TypeStr)
        {
            case "mapserver": return new MapServiceMessage();
            case "featureserver":return new FeatureServiceMessage();
            case "gpserver":return  new GPServiceMessage();
            case "geometryserver": return new GeometryServiceMessage();
            default: return new BaseMessage();
        }
    }
}
