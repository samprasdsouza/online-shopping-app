package com.example.demo.dao;

import com.example.demo.model.CustomerDetails;
import java.util.List;
import java.util.Optional;


public interface CustomerDao {


    int insertCustomer(CustomerDetails  customerDetails);

    List<CustomerDetails> selectAllCustomer();

    int deleteCustomerByUsername(CustomerDetails customerDetails);

    int updateCustomerByUsername(CustomerDetails customerDetails);


}
