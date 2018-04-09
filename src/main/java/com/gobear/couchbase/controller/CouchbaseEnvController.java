package com.gobear.couchbase.controller;

import com.gobear.couchbase.CouchbaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CouchbaseEnvController {



    @Autowired
    private CouchbaseConfiguration configuration;

    @RequestMapping("/couchbase/info")
    @ResponseBody
    public Map<String, String> getConfigInfo() {
        Map<String, String> configs = new HashMap<>();
        configs.put("config-info", configuration.getConfigInfo());
        return configs;
    }

    @RequestMapping("/couchbase/env")
    @ResponseBody
    public Map<String, String> getEnvironment() {
        Map<String, String> configs = new HashMap<>();
        configs.put("couchbase-env", configuration.getEnv());
        return configs;
    }


}
