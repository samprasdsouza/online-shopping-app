package com.example.demo.service.Customer;

import com.example.demo.dao.Customer.CustomerDao;
import com.example.demo.model.Customer.CustomerDetails;
import com.example.demo.model.Customer.CustomerValidation;
import com.example.demo.model.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("CustomerModelPostgres") CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public String addCustomer(CustomerDetails customerDetails ){
        return customerDao.insertCustomer(customerDetails);
    }

    public  String ValidateCustomer(CustomerValidation customerValidation)
    {
        return customerDao.ValidateCustomer(customerValidation);
    }


    public String updateCustomer( String customer_username,CustomerDetails customerDetails) {
        return customerDao.updateCustomerByUsername(customer_username,customerDetails);
    }

    public String getCustomerDetails(String customer_username)
    {
        return customerDao.GetCustomerDetails(customer_username);
    }

//        return CustomerDao.updateCustomerByUsername(customer_username,customerDetails)
//    public int updatePerson(UUID id, Person newPerson){
//        return personDao.updatePersonById(id,newPerson);
//    }

}
