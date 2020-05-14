package com.clubprogramacionbarbaro.covidapi.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${api.version}")
	private String apiVersion;
	
	@Value("${api.title}")
	private String apiName;
	
	public Contact contact() {
		return new Contact("Leopoldo López", "elbarbaro.com", "leolopezdealba94@gmail.com");
	}
	
	@Bean
	public ApiInfo apiInfo() {
		ApiInfo apiInfo = new  ApiInfoBuilder()
				.title(apiName)
				.description("This API helps the hospitals to always have the necessary material during the covid19 pandemy")
				.version(apiVersion)
				.license("Apache 2.0")
				.termsOfServiceUrl("Free use")
				.contact(contact())
				.build();
		return apiInfo;
	}
	
	@Bean
	public Docket api(ApiInfo apiInfo) {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.clubprogramacionbarbaro.covidapi"))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(securitySchemes())
				.securityContexts(securityContext())
				.apiInfo(apiInfo)
				.produces(producesAndConsumes())
				.consumes(producesAndConsumes());
				//.globalOperationParameters(operationParameters());
	}
	
	private List<SecurityContext> securityContext() {
		return Arrays.asList(SecurityContext.builder()
				.securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex("/v1.*"))
				.build());
	}
	
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("Bearer", authorizationScopes));
	}
	
	private List<ApiKey> securitySchemes() {
		return Arrays.asList(new ApiKey("Bearer", "Authorization", "header"));
	}
	
	public List<Parameter> operationParameters() {
		List<Parameter> parameters = new ArrayList<>();
		parameters.add(new ParameterBuilder().name("Authorization").description("Authorization")
				.modelRef(new ModelRef("String")).parameterType("header").required(false).build());
		return parameters;
	}
	
	private Set<String> producesAndConsumes() {
		return new HashSet<>(Arrays.asList("application/json", "application/xml"));
	}
}
