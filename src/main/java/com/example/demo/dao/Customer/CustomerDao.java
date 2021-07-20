package com.example.demo.dao.Customer;

import com.example.demo.model.Customer.*;
import com.example.demo.model.Product.Product_Details;

import java.util.List;


public interface CustomerDao {


    String insertCustomer(CustomerDetails  customerDetails);

    List<Customer_Username> selectAllCustomer();

    int deleteCustomerByUsername(CustomerDetails customerDetails);

    String updateCustomerByUsername(String customer_username,CustomerDetails customerDetails);

    String ValidateCustomer(CustomerValidation customerValidation);

    CustomerDetails GetCustomerDetails(String customer_username);

    List<Customer_Cart> UserCart(Customer_Username customer_username);

    String InsertToCart(Customer_Cart customer_cart);

    String DeleteFromCart(String customer_Username, Product_Details product_details);

    List<Customer_Orders> allOrders(Customer_Username customer_username);

    String ordered_executed_successfully(String customer_username);
}
