package com.jaztest.jazs21912nbp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "app")
public class StaticDataConf {
    private Map<String, EnvData> data;

    public Map<String, EnvData> getData() {
        return data;
    }

    public void setData(Map<String, EnvData> data) {
        this.data = data;
    }
}
