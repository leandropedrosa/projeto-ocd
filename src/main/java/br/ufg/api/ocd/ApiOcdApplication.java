package br.ufg.api.ocd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableSwagger2
public class ApiOcdApplication {


	public static void main(String[] args) {
		SpringApplication.run(ApiOcdApplication.class, args);
	}


}
