package com.example.demo.service.Customer;

import com.example.demo.dao.Customer.CustomerDao;
import com.example.demo.model.Customer.CustomerDetails;
import com.example.demo.model.Customer.CustomerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("CustomerModelpostgres") CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public int addCustomer(CustomerDetails customerDetails ){
        return customerDao.insertCustomer(customerDetails);
    }

    public  String ValidateCustomer(CustomerValidation customerValidation)
    {
        return customerDao.ValidateCustomer(customerValidation);
    }
}
