package com.example.demo.service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.CustomerDetails;
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
}
