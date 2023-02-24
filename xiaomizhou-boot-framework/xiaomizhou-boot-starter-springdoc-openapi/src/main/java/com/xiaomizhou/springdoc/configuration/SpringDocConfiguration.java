package com.xiaomizhou.springdoc.configuration;

import com.xiaomizhou.springdoc.properties.SpringDocProperties;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.Constants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaomizhou
 * @date 2023/2/24
 * @email 521jx123@gmail.com
 */
@Configuration
@EnableConfigurationProperties({SpringDocProperties.class})
@ConditionalOnProperty(name = Constants.SPRINGDOC_ENABLED, matchIfMissing = true)
public class SpringDocConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public OpenAPI openAPI(SpringDocProperties properties) {
        OpenAPI openAPI = new OpenAPI()
                .components(new Components().addSecuritySchemes(properties.getSecurityScheme().getName(), properties.getSecurityScheme()))
                .info(properties.getInfo());

        if (properties.getServer() != null && !properties.getServer().isEmpty()) {
            openAPI.servers(properties.getServer());
        }
        return openAPI;
    }

}
