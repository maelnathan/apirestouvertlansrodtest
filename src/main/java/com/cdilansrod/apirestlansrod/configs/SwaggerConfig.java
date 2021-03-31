package com.cdilansrod.apirestlansrod.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import static springfox.documentation.builders.PathSelectors.regex;
import java.util.Arrays;

/**
 * @author OULLA Jean Honorat
 * oullajean@gmail.com
 * (225) 0748492876
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.cdilansrod.apirestlansrod.web.apirest"))
           .paths(regex("/api.*"))
           .build()
          .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        @SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo(
                "API REST pour LANSROD TEST",
                "API pour la gestion des ressources humaines des entreprises",
                "1.0",
                "Par Jean Honorat OULLA",
                Arrays.asList(
                        new Contact("Jean Honorat OULLA", "225 0748492876", "oullajean@gmail.com")
                ).toString(),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }


}
