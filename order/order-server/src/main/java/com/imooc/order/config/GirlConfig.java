package com.imooc.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**-
 *
 */
@Data
@Component
//@EnableConfigurationProperties(GirlConfig.class)
@ConfigurationProperties("girl")
@RefreshScope
public class GirlConfig {

    private String name;

    private String age;
}
