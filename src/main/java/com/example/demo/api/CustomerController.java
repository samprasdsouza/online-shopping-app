package com.example.demo.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    @GetMapping("/getMsg")
    public String greeting()
    {
        return "spring security example";
    }
}
