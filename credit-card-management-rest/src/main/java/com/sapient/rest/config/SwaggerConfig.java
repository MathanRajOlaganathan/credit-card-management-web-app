package com.sapient.rest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 04/07/2021
 */
@Configuration
public class SwaggerConfig {

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.description}")
    private String appDescription;

    @Value("${spring.application.name}")
    private String title;


    @Bean
    public OpenAPI openAPI() {

        Contact contact = new Contact();
        contact.setEmail("omrfrance1990@gmail.com");
        contact.setUrl("https://www.linkedin.com/in/mathanrajo");
        contact.setName("Mathan Raj Olaganathan");

        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .description(appDescription)
                        .version(appVersion)
                        .contact(contact));
    }
}
