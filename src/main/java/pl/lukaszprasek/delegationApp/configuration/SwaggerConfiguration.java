package pl.lukaszprasek.delegationApp.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(apiPath())
                .build()
                .globalResponseMessage(RequestMethod.GET, response());
    }

    private List<ResponseMessage> response() {

        return newArrayList(new ResponseMessageBuilder().code(500)
                .message("System error")
                .responseModel(new ModelRef("Error"))
                .build(), new ResponseMessageBuilder().code(400)
                .message("Wrong request")
                .build(), new ResponseMessageBuilder().code(401)
                .message("Unauthorized")
                .build());
    }

    private List<ResponseMessage> newArrayList(ResponseMessage... build) {
        return Arrays.asList(build);

    }

    private Predicate<String> apiPath() {
        return PathSelectors.any();// .ant("/rest/v1/**");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("DelegationApp")
                .description("Training App")
                .license("Luk Prasek")
                .version("1.0")
                .build();
    }
}
