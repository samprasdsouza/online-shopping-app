package com.example.demo.dao.Customer;

import com.example.demo.dao.Customer.CustomerDao;
import com.example.demo.model.Customer.CustomerDetails;
import com.example.demo.model.Customer.CustomerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("CustomerModelpostgres")
public class CustomerDataAccessService implements CustomerDao {


    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CustomerDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertCustomer(CustomerDetails customerDetails) {
        System.out.println("Adding New Customer");
        System.out.println(customerDetails.getCustomer_name());
        System.out.println(customerDetails.getCustomer_email());
        System.out.println(customerDetails.getCustomer_contact());
        System.out.println(customerDetails.getCustomer_address());
        System.out.println(customerDetails.getCustomer_password());
        System.out.println(customerDetails.getCustomer_username());

        return 0;
    }

    @Override
    public List<CustomerDetails> selectAllCustomer() {
        return null;
    }

    @Override
    public int deleteCustomerByUsername(CustomerDetails customerDetails) {
        return 0;
    }

    @Override
    public int updateCustomerByUsername(CustomerDetails customerDetails) {
        return 0;
    }

    @Override
    public String ValidateCustomer(CustomerValidation customerValidation) {
       System.out.println(" Validating User Name and Password");

       System.out.println(customerValidation.getCustomer_username());
       System.out.println(customerValidation.getCustomer_password());
         //Query To Validate The UserName and Password
        return null;
    }
}
//{
//        "customer_name":"sam",
//        "customer_email":"samprasdsouza02@gmail.com",
//        "customer_contact":"9819955913",
//        "customer_address":"mumbai",
//        "customer_password":"Lazarus",
//        "customer_username":"dsouza_sam"
//        }