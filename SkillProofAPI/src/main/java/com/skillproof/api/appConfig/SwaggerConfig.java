package com.skillproof.api.appConfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@Configuration
public class SwaggerConfig{

    @Bean
    @Primary
    public OpenAPI documentation(){
        return new OpenAPI()
                .info(new Info()
                        .title("Skill Bridge Social Media Platform")
                        .version("1.0")
                        .license(new License().name("SkillBridge"))
                        .contact(new Contact().name("SkillBridge Team").email("skillbridge@skillbridge.tech")));
    }
}
//
