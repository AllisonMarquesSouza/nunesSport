package com.br.nunes.sports.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Nunes Sports")
                        .version("v1.0.0")
                        .description("Application to management products")
                        .termsOfService("https://github.com/AllisonMarquesSouza/nunesSport")
                        .contact(new Contact()
                                .name("Support for email")
                                .email("allisonsouza10261@gmail.com"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Nunes Sports GitHub Documentation")
                        .url("https://github.com/AllisonMarquesSouza/nunesSport"));
    }
}