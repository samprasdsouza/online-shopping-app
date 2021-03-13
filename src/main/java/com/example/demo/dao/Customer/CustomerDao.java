package com.example.demo.dao.Customer;

import com.example.demo.model.Customer.CustomerDetails;
import com.example.demo.model.Customer.CustomerValidation;

import java.util.List;


public interface CustomerDao {


    int insertCustomer(CustomerDetails  customerDetails);

    List<CustomerDetails> selectAllCustomer();

    int deleteCustomerByUsername(CustomerDetails customerDetails);

    int updateCustomerByUsername(CustomerDetails customerDetails);

    String ValidateCustomer(CustomerValidation customerValidation);

}
