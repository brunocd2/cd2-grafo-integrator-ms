package br.com.cd2.integrator.core.ms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.build().apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET
						,responseMessageGET());
		
	}
	private List<ResponseMessage> responseMessageGET(){
		return new ArrayList<ResponseMessage>() {{
			add(new ResponseMessageBuilder()
					.code(500)
					.message("Erro 500")
					.responseModel(new ModelRef("Erro"))
					.build()
					);
			add(new ResponseMessageBuilder()
					.code(403)
					.message("Forbidden")
					.responseModel(new ModelRef("Forbidden!"))
					.build()
					);
		}};
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("CD2 Grafo Integrator ms")
	            .description("Sistema responsável integração e insersão dos produtos de clientes internos e externos gerados no projeto CD2 Grafo Integrator.")
	            .version("1.0.0")
	            .license("CD2 licenced 2.0")
	            .licenseUrl("https://www.cd2.com.br")
	            .contact(new Contact("Bruno Santos", "https://www.cd2.com.br", "bruno.santos@cd2.com.br"))
	            .build();
	}
	
}
