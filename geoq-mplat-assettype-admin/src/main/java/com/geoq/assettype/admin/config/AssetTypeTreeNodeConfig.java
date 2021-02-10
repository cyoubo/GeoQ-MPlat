package com.geoq.assettype.admin.config;

import cn.hutool.core.lang.tree.TreeNodeConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "treenode")
@Configuration
@Data
public class AssetTypeTreeNodeConfig {

    private String ParentIdKey;
    private String NameKey;
    private int Deep;
    private String IdKey;

    @Bean
    public TreeNodeConfig treeNodeConfig(){
        TreeNodeConfig temp =  new TreeNodeConfig();
        temp.setParentIdKey(ParentIdKey);
        temp.setNameKey(NameKey);
        temp.setDeep(Deep);
        temp.setIdKey(IdKey);
        return temp;
    }
}
