package org.hometask41.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
    @Value("${example.value.count:34}")
    private Integer exampleValue;
    @Value("${example.string.name:error}")
    private String exampleString;

    @GetMapping()
    public String test(){
        System.out.println("example value:" + exampleValue);
        System.out.println("example string:" + exampleString);
        return "null";
    }
}