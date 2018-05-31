package com.wzy.springboot_demo.enttiy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * springboot_demo
 * 服务器配置
 *
 * @author Wang Zhiyuan
 * @date 2018-05-31 17:13
 **/
@Component
@PropertySource({"classpath:application.properties"})
@ConfigurationProperties
public class ServerSettings {
    private String name;
    private String domain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
