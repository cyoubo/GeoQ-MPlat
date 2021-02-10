package com.geoq.arcgisservice.harvest.component;


import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 * 实际项目中关心的地图服务元数据描述项目信息实体类
 */
@Data
@NoArgsConstructor
public class MapServiceContext extends AbstractServiceContext {

    private List<String> Layers;

    @Override
    public String toJson() {
        return JSONUtil.toJsonStr(this);
    }

    @Override
    public AbstractServiceContext extract(String temp) {
        return null;
    }
}
