package com.geoq.arcgisservice.harvest.serviceImp;

import cn.hutool.json.JSONUtil;
import com.geoq.arcgisservice.harvest.pojo.ServiceRecord;
import com.geoq.arcgisservice.harvest.service.ProbeService;
import com.geoq.arcserver.admin.message.element.Catalog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProbeServiceImp implements ProbeService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public List<ServiceRecord> probeService(String host) {
        List<ServiceRecord> result = new ArrayList<>();
        //先查看根目录
        String host_url = String.format("%s/arcgis/rest/services?f=json",host);
        log.info(host_url);
        String response = restTemplate.getForObject(host_url, String.class);
        Catalog root = JSONUtil.toBean(JSONUtil.parseObj(response),Catalog.class);
        for (com.geoq.arcserver.admin.message.element.Service service : root.getServices()) {
            result.add(new ServiceRecord("",service.getName(), service.getType()));
        }
        //再查看子目录
        for (String folder : root.getFolders()) {
            String fold_url = String.format("%s/arcgis/rest/services/%s?f=json",host,folder);
            String response_fold = restTemplate.getForObject(fold_url, String.class);
            Catalog fold = JSONUtil.toBean(JSONUtil.parseObj(response_fold),Catalog.class);
            for (com.geoq.arcserver.admin.message.element.Service service : fold.getServices()) {
                result.add(new ServiceRecord(folder,service.getName().split("/")[1], service.getType()));
            }
        }
        return result;
    }
}
