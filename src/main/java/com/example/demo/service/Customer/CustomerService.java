package com.example.demo.service.Customer;

import com.example.demo.dao.Customer.CustomerDao;
import com.example.demo.model.Customer.*;
import com.example.demo.model.Person.Person;
import com.example.demo.model.Product.Product_Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public CustomerDetails getCustomerDetails(String customer_username)
    {
        return customerDao.GetCustomerDetails(customer_username);
    }

    public List<Customer_Cart> getUserCart(Customer_Username customer_username)
    {
        return customerDao.UserCart(customer_username);
    }

    public String Insert_to_Cart(Customer_Cart customer_cart)
    {
        return customerDao.InsertToCart(customer_cart);
    }
    public String Delete_from_Cart(String customer_username, Product_Details product_details)
    {
        return customerDao.DeleteFromCart(customer_username,product_details);
    }


    public List<Customer_Orders> getallOrders(Customer_Username customer_username)
    {
        return customerDao.allOrders(customer_username);
    }

    public  String ordered_successfully(String customer_username)
    {
        return customerDao.ordered_executed_successfully(customer_username);
    }
    //list of all customer_username
    public List<Customer_Username> allCustomerUsername() {
        return customerDao.selectAllCustomer();
    }


//        return CustomerDao.updateCustomerByUsername(customer_username,customerDetails)
//    public int updatePerson(UUID id, Person newPerson){
//        return personDao.updatePersonById(id,newPerson);
//    }

}
