package com.xiaomizhou.springdoc.properties;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

/**
 * @author xiaomizhou
 * @date 2023/2/24
 * @email 521jx123@gmail.com
 */
@Data
@ConfigurationProperties(prefix = "springdoc")
public class SpringDocProperties {
    @NestedConfigurationProperty
    private Info info;
    @NestedConfigurationProperty
    private SecurityScheme securityScheme;
    @NestedConfigurationProperty
    private List<Server> server;

}
