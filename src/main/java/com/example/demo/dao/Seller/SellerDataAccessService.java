package com.example.demo.dao.Seller;


import com.example.demo.model.Seller.SellerDetails;
import com.example.demo.model.Seller.SellerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SellerModelPostgres")
public class SellerDataAccessService  implements SellerDao{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public SellerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertSeller(SellerDetails sellerDetails) {
         System.out.println("Inserted Seller");
         System.out.println(sellerDetails.getSeller_name());
        System.out.println(sellerDetails.getSeller_email());
        System.out.println(sellerDetails.getSeller_contact());
        System.out.println(sellerDetails.getSeller_address());
        System.out.println(sellerDetails.getSeller_password());
        System.out.println(sellerDetails.getSeller_username());

        return 0;
    }

    @Override
    public List<SellerDetails> selectALlSeller() {
        return null;
    }

    @Override
    public String updateSellerByUsername(String seller_username, SellerDetails sellerDetails) {
        System.out.println(seller_username);
        System.out.println(sellerDetails.getSeller_name());
        System.out.println(sellerDetails.getSeller_email());
        System.out.println(sellerDetails.getSeller_contact());
        System.out.println(sellerDetails.getSeller_address());
        System.out.println(sellerDetails.getSeller_password());
        System.out.println(sellerDetails.getSeller_username());
        return null;
    }

    @Override
    public String ValidateSeller(SellerValidation sellerValidation) {
         System.out.println("Validating Seller User_name and Password");

        System.out.println(sellerValidation.getSeller_username());
        System.out.println(sellerValidation.getSeller_password());
        return null;
    }

    @Override
    public String GetSellerDetails(String seller_username) {
        System.out.println(seller_username);

        return null;
    }
}
