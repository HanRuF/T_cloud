package com.xiaoyu.tpolice.c;

import io.swagger.annotations.*;
import org.apache.http.HttpRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(value = "/nn" ,tags="第一个接口")
@RestController
public class TestController {

    @ApiOperation(value = "输出信息",notes = "就那么简单的无参接口")
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public  String home(){
        return "hello world from port";
    }

    @ApiOperation(value = "咨询信息",notes = "找到你，需要找的人了么？")
    //对应接收参数名的解释
    @ApiImplicitParam(name = "customerservice",value = "参数1",required = true,dataType ="CustomerService")
    @RequestMapping(value = "/view",method = RequestMethod.POST,consumes ="application/json" )
    //@RequestBody  接收正文传递参数  只能传递一个参数
    //如何需要多个参数传递过来，可以包装成一个对象数据
    public CustomerService view(HttpServletRequest req, @RequestBody CustomerService customerservice
                                 ){
        System.out.println("a==="+customerservice.getName());
        System.out.println("b==="+customerservice.getSex());
        CustomerService customerService=new CustomerService();
        customerService.setName(customerservice.getName());
        customerService.setSex(customerservice.getSex());
        customerService.setManager(req.getRequestURL().toString());
        return customerService;
    }


    @ApiOperation(value = "咨询信息2",notes = "找到你，需要找的人了么？")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a",value = "参数1",required = true,dataType ="String",paramType = "query"),
            @ApiImplicitParam(name = "b",value = "参数2",required = false,dataType ="String",paramType = "query")
    })
    @RequestMapping(value = "/view1",method = RequestMethod.POST)
    //@RequestParam   接口   http://www.x.com?a=a&b=1   该格式信息
    public CustomerService ViewTest(@RequestParam("a") String a,@RequestParam("b") String b){
        System.out.println("a==="+a);
        System.out.println("b==="+b);
        CustomerService customerService=new CustomerService();
        customerService.setName("李四");
        customerService.setSex("男");

        return customerService;
    }


    @ApiOperation(value = "咨询信息3",notes = "找到你，需要找的人了么？")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a",value = "参数1",required = true,dataType ="String",paramType = "path"),
            @ApiImplicitParam(name = "b",value = "参数2",required = false,dataType ="String",paramType = "path")
    })
    @RequestMapping(value = "/view2/{a}/{b}",method = RequestMethod.GET)
    //@PathVariable   接口   http://www.x.com/xx/2   该格式信息  目录结构信息
    public CustomerService ViewTestTwo(@PathVariable("a") String a,@PathVariable("b") String b){
        System.out.println("a==="+a);
        System.out.println("b==="+b);
        CustomerService customerService=new CustomerService();
        customerService.setName("李四");
        customerService.setSex("男");

        return customerService;
    }


    @ApiOperation(value = "咨询信息4",notes = "找到你，需要找的人了么？")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a",value = "参数1",required = true,dataType ="String",paramType = "query"),
            @ApiImplicitParam(name = "b",value = "参数2",required = false,dataType ="int",paramType = "query")
    })
    @RequestMapping(value = "/view3",method = RequestMethod.GET)
    public CustomerService ViewTestThree( String a,
                                          int b,@RequestHeader HttpHeaders httpheaders){
        System.out.println("token==="+httpheaders.getFirst("X-Auth-Token"));
        System.out.println("password==="+httpheaders.getFirst("X-Auth-Password"));
        System.out.println("a==="+a);
        System.out.println("b==="+b);
        CustomerService customerService=new CustomerService();
        customerService.setName("李四");
        customerService.setSex("男");

        return customerService;
    }

    @ApiOperation(value = "咨询信息5",notes = "找到你，需要找的人了么？")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a",value = "参数1",required = true,dataType ="String",paramType = "query"),
            @ApiImplicitParam(name = "b",value = "参数2",required = false,dataType ="int",paramType = "query")
    })
    @RequestMapping(value = "/view4",method = RequestMethod.GET)
    public CustomerService ViewTestFour(String a,
                                        int b, @Valid CustomerService customerservice, @RequestHeader HttpHeaders httpheaders, BindingResult bindingResult){
        System.out.println("token==="+httpheaders.getFirst("X-Auth-Token"));
        System.out.println("password==="+httpheaders.getFirst("X-Auth-Password"));
        System.out.println("a==="+a);
        System.out.println("b==="+b);
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        CustomerService customerService=new CustomerService();
        customerService.setName("李四");
        customerService.setSex("男");

        return customerService;
    }


}
