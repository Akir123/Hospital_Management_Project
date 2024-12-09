package com.user.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Hospital Management API")
                .description("Hospital Management API with OAuth2 Security")
                .version("v1.0"))
            .addSecurityItem(new SecurityRequirement().addList("OAuth2"))
            .components(new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes("OAuth2",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.OAUTH2)
                        .flows(new OAuthFlows()
                            .authorizationCode(new OAuthFlow()
                                .authorizationUrl("http://localhost:9192/realms/yt-dev/protocol/openid-connect/auth")
                                .tokenUrl("http://localhost:9192/realms/yt-dev/protocol/openid-connect/token")
                                .scopes(new io.swagger.v3.oas.models.security.Scopes()
                                        .addString("read", "Read access to resources")
                                        .addString("write", "Write access to resources")
                                    )
                            )
                        )
                )
            );
    }
}
