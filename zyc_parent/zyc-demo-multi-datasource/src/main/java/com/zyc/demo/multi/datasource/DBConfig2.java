package com.zyc.demo.multi.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/4/14 13:00
 */
@Data
@ConfigurationProperties(prefix = "mysql.datasource.test2")
//@Component
public class DBConfig2 {

    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
}
