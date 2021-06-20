package com.returnordermanag.paymentService;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class PaymentServiceApplication {

	static Logger logger = LoggerFactory.getLogger(PaymentServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
		logger.info("Payment Service Application started successfully");
	}

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.returnordermanag.paymentService")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Payment Service API", "This API is used during payment gateway, to check the card availability and its credit limit.", 
				"API", "Terms of service",
				new Contact("Abhishek Gupta", "", "eluriabhishekgupta@gmail.com"), "License of API", "",Collections.emptyList());
	}

}
