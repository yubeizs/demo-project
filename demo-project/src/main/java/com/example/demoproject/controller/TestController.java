package com.example.demoproject.controller;

import com.alibaba.fastjson.JSON;
import com.example.demoproject.annotion.TestAnno;
import com.example.demoproject.constant.TestConstant;
import com.example.demoproject.dto.ValidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.applet.AppletContext;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RestController
@TestAnno(values = TestConstant.BOSS)
public class TestController {

    @Autowired
    TestService testService;

    // Spring应用上下文环境
     private ApplicationContext applicationContext;

    @PostMapping("/test")
    @TestAnno(values = TestConstant.STAFF)
    public Map<String,String> get(){
       Map<String,String> map = new HashMap();
       map.put("response","success");
        HashSet<String> strings = new HashSet<>();
        Date date;
        Object applicationContext = this.applicationContext.getBean("applicationContext");

        return map;
    }

    @RequestMapping("test-str")
    public String testStr(){
        return "order,list";
    }

    @PostMapping(value = "test-valid")
    public String testValid(@RequestBody @Valid ValidDTO validDTO){

        return JSON.toJSONString(validDTO);
    }
}
