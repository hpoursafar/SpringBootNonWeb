package com.example.demo.controller.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
public class HelloWorldController {

    
//    @RequestMapping("hello-world")
//    @ResponseBody
    public String helloWorld(){
        System.out.print("Hello World!");
        return "Hello World!";
    }
    
}
