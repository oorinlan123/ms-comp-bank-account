package ec.nttdata.bankAccount.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Value("${domain.swagger}")
	private String domain;

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
			Arrays.asList("application/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("ec.nttdata.bankAccount.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.apiInfo())
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES)
				.host(domain)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("OrderService",
				"Servicio de Gestión de Pedidos", "v1.0", "Todos los derechos otorgados",
				new Contact("Israel Guacho", "", "israel.guachog@gmail.com"),
				"Licencia del API", "", Collections.emptyList());
	}
}
