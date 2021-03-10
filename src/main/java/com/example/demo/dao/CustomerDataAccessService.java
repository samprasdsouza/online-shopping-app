package com.example.demo.dao;

import com.example.demo.model.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("CustomerModelpostgres")
public class CustomerDataAccessService implements CustomerDao{


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
}
