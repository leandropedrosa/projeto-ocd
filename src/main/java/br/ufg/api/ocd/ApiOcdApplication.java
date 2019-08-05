package br.ufg.api.ocd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableSwagger2
public class ApiOcdApplication  {


	public static void main(String[] args) {
		SpringApplication.run(ApiOcdApplication.class, args);
	}
/*
	@RefreshScope
	@RestController
	class MessageRestController {

		@Value("${message:Hello default}")
		private String message;

		@RequestMapping("/message")
		String getMessage() {
			return this.message;
		}
	}
*/
}
