package com.compont;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhuzhengping on 2017/2/12.
 */
@Component
@ConfigurationProperties(prefix = "zzp")
public class ZzpProperties {

    private String title;

    private String description;

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
