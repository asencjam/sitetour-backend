package com.spgi.sitetour;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Site Tour API", version = "1.0.0", description = "This is the API that handles the use cases and description for the Site Tour")
)
public class SitetourBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SitetourBackendApplication.class, args);
	}

}
