package com.example.demo.api.Customer;

import com.example.demo.model.Customer.CustomerDetails;
import com.example.demo.model.Customer.CustomerValidation;
import com.example.demo.model.Person.Person;
import com.example.demo.service.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@RequestMapping("api/v1/")
@RestController
public class CustomerController {

    @Autowired
    private  final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path="/registerNewCustomer")
    public  void addCustomer (@Valid @NotNull @RequestBody CustomerDetails customerDetails){
        System.out.println("Adding People");
        //security check class
//        apiValidation.personValidator(person);
        //
        customerService.addCustomer(customerDetails);
    }

    @PostMapping(path = "/ValidateUser")
    public  void ValidateCustomer(@Valid @NotNull @RequestBody CustomerValidation customerValidation )
    {
        System.out.println("Validating User");
        customerService.ValidateCustomer(customerValidation);
    }
//
    @PutMapping(path ="{customer_username}" )
    public void updateCustomer(@PathVariable("customer_username") String customer_username, @Valid @NotNull @RequestBody CustomerDetails CustomerToUpdate){
      //
        customerService.updateCustomer(customer_username,CustomerToUpdate);
    }
//
    @GetMapping(path="{customer_username}")
    public void GetCustomerDetails(@PathVariable("customer_username")String customer_username)
    {
        customerService.getCustomerDetails(customer_username);
    }


    @GetMapping("/getMsg")
    public String greeting()
    {
        return "spring security example";
    }
}
