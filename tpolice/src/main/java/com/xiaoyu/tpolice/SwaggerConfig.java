package com.xiaoyu.tpolice;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //存在token信息
    @Bean
    public Docket docket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //路径地址  采用包扫描的方式来确定要显示的接口
                //.apis(RequestHandlerSelectors.basePackage("com.xiaoyu.tpolice"))
                //采用包含注解的方式来确定要显示的接口
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //接口过滤
                .paths(PathSelectors.any())
                //正侧表达式筛选
              //  .paths(PathSelectors.regex("/view.*"))

                .build()
                //可提交对应header信息
                .globalOperationParameters(setHeaderToken())
                ;
    }

    //不存在token类接口
    //@Bean
    public  Docket pubDocument(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //路径地址  采用包扫描的方式来确定要显示的接口
                //.apis(RequestHandlerSelectors.basePackage("com.xiaoyu.tpolice"))
                //采用包含注解的方式来确定要显示的接口
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //接口过滤
//                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/home.*"))
                .build()
                //可提交对应header信息
                ;
    }


   private List<Parameter> setHeaderToken(){
       ParameterBuilder tokenPar=new ParameterBuilder();
       ParameterBuilder passwordPar=new ParameterBuilder();
       List<Parameter> pars=new ArrayList<>();
       tokenPar
               //表示名称
               .name("X-Auth-Token")
               //描述信息，header需要提交信息
               .description("token")
               .modelRef(new ModelRef("String"))
               .parameterType("header")
               //表示是否必填
               .required(false)
               //表示默认值
               .defaultValue("*")
               .build();
       passwordPar
               //表示名称
               .name("X-Auth-Password")
               //描述信息，header需要提交信息
               .description("password")
               .modelRef(new ModelRef("String"))
               .parameterType("header")
               //表示是否必填
               .required(false)
               //表示默认值
               .defaultValue("*")
               .build();
       pars.add(tokenPar.build());
       pars.add(passwordPar.build());
       return  pars;
   }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //页面标题信息
                .title("菜鸟RESTful API接口")
                //作者 创建者
                .contact(new Contact("菜鸟到此","http://www.ss.com",""))
                //版本号
                .version("2.0")
                //描述信息
                .description("菜鸟学习")
                .build();
    }

}
