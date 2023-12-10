package com.dailycode.springboottut.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String helloNajriya()
    {
        return "Welcome lovely nazriya i love u";
    }
}
