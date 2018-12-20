package com.xiaoyu.demotest.Contiller;

import com.xiaoyu.demotest.modle.TestModle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/lombok")
public class TestContiller {

    @RequestMapping(value ="/view",method = RequestMethod.GET)
    public TestModle view(){
        TestModle testModle=new TestModle();
        testModle.setAge("21ffff");
        testModle.setName("你好");
        return testModle;
    }
}
