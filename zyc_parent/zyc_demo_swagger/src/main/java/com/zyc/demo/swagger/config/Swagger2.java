package com.zyc.demo.swagger.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Profile 注解 标识加载在dev和test文件使用
 * @author zhouyicai
 * @Description: TODO
 * @date 2020/1/11 8:36
 */
@Configuration  //声明这是一个配置类
@EnableSwagger2
@Profile({"dev", "test"})
public class Swagger2 {
    @Bean
    public Docket customerDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                /**加载配置信息*/
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                /**设置全局参数*/
                .globalOperationParameters(globalParamBuilder())
                .select()
                /**加载swagger 扫描包*/
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();

    }
    /**
     * 获取swagger创建初始化信息
     * @return
     */
    private ApiInfo apiInfo(){
        Contact contact = new Contact("zhouyic", "", "592519679@qq.com");
        return new ApiInfoBuilder().title("swagger Demo 测试项目").contact(contact).build();
    }

    /**
     * 构建全局参数列表
     * @return
     */
    private List<Parameter> globalParamBuilder(){
        List<Parameter> pars = new ArrayList<>();
        pars.add(parameterBuilder("token","令牌","string","header",false).build());
        return pars;
    }

    /**
     * 创建参数
     * @param name
     * @param desc
     * @param type
     * @param parameterType
     * @param required
     * @return
     */
    private ParameterBuilder parameterBuilder(String name,String desc,String type,String parameterType,boolean required){
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(name)
                .description(desc)
                .modelRef(new ModelRef(type)).
                parameterType(parameterType)
                .required(required)
                .build();
        return tokenPar;
    }
}
