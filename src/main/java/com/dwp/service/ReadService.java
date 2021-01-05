package com.dwp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 调度redis业务逻辑类
 *
 * @author dengweiping
 * @date 2020/12/31 11:51
 */
@Service
public class ReadService {
    @Autowired
    private RestTemplate restTemplate;

    public Object read(String key) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "邓卫平");
        map.put("age", 23);
        map.put("address", "湖北恩施");

        write(map);
        return restTemplate.getForObject("http://programmer-tool-reader/api/redis/" + key, Object.class);
    }

    public Object write(Map<String, Object> map) {
        return restTemplate.postForObject("http://programmer-tool-reader/api/redis", map, Object.class);
    }
}
