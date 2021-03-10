package com.example.demo.api;

import com.example.demo.model.CustomerDetails;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RequestMapping("api/v1/")
@RestController
public class CustomerController {

    @Autowired
    private  final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path="/newCustomer")
    public  void addCustomer (@Valid @NotNull @RequestBody CustomerDetails customerDetails){
        System.out.println("Adding People");
        //security check class
//         apiValidation.personValidator(person);
        //
        customerService.addCustomer(customerDetails);
    }

    @GetMapping("/getMsg")
    public String greeting()
    {
        return "spring security example";
    }
}
