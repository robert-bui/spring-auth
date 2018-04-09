package com.gobear.ignite.controller;

import com.gobear.ignite.service.IgniteCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Collection;

@Controller
@RequestMapping("/cache")
@EnableAutoConfiguration
public class IgniteCacheController {


    @Autowired
    private IgniteCacheService cacheService;

    @RequestMapping("/getall")
    @ResponseBody
    public Object getAllCaches() {
        Collection<String> cacheNames = cacheService.getAllCacheNames();
        return Arrays.toString(cacheNames.toArray());

    }

    @RequestMapping("/get")
    @ResponseBody
    public Object getCache(@RequestParam String cacheName, @RequestParam String key) {
        return cacheService.getCacheValue(cacheName, key);
    }

}
