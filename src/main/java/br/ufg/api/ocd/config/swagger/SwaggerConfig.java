package br.ufg.api.ocd.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String AUTH_SERVER = "http://localhost:8080/oauth";
    public static final String CLIENT_ID = "ocdClientId";
    public static final String CLIENT_SECRET = "0f324881ebb170dc71382d558e1b424d";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.ufg.api.ocd.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Arrays.asList(securityScheme()))
                .securityContexts(Arrays.asList(securityContext()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("OCD Management Rest APIs")
                .description("Oral Cancer Detect (OCD). Management App.")
                .license("OCD License Version 2.0")
                .contact(new Contact("Oral Cancer Detect - UFG", "https://portal-ocdp-f70da.firebaseapp.com/home", "leandropedrosalp@gmail.com"))
                .version("1.0-SNAPSHOT")
                .build();
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder().clientId(CLIENT_ID).clientSecret(CLIENT_SECRET).useBasicAuthenticationWithAccessCodeGrant(true).build();
    }

    private SecurityScheme securityScheme() {
        GrantType grantType = new AuthorizationCodeGrantBuilder().tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken")).tokenRequestEndpoint(new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_ID)).build();

        SecurityScheme oauth = new OAuthBuilder().name("spring_oauth").grantTypes(Arrays.asList(grantType)).scopes(Arrays.asList(scopes())).build();
        return oauth;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(Arrays.asList(new SecurityReference("spring_oauth", scopes()))).forPaths(PathSelectors.regex("/foos.*")).build();
    }

    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {new AuthorizationScope("read", "para operações de leitura"), new AuthorizationScope("write", "para operações de gravação"), new AuthorizationScope("foo", "Acesso total à API")};
        return scopes;
    }
}