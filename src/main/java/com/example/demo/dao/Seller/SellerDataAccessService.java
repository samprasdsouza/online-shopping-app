package com.example.demo.dao.Seller;


import com.example.demo.model.Seller.*;
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

    @Override
    public String InsertProduct(SellerProduct sellerProduct) {
        System.out.println(sellerProduct.getSeller_id());
        System.out.println(sellerProduct.getProduct_id());
        System.out.println(sellerProduct.getProduct_price());
        System.out.println(sellerProduct.getProduct_image_path());

        // query to insert product
        return null;
    }

    @Override
    public String AllSellerProducts(Seller_UserName seller_userName) {
        System.out.println(seller_userName.getSeller_username());
        //query for getting all the seller products
        return null;
    }

    @Override
    public String getProductDetails(String Product_name, Seller_UserName seller_userName) {
        System.out.println(Product_name);
        System.out.println(seller_userName.getSeller_username());
        return null;
    }

    @Override
    public String updateProductDetails(String product_name, SellerProductUpdate sellerProductUpdate) {
        System.out.println(product_name);
        System.out.println(sellerProductUpdate.getProduct_price());
        System.out.println(sellerProductUpdate.getProduct_image_path());

        //query to update products
        return null;
    }

    @Override
    public String allOrders(Seller_UserName seller_userName) {
        System.out.println(seller_userName.getSeller_username());
        return null;
    }

    @Override
    public String order_details(int customer_order_no, Seller_UserName seller_userName) {
        System.out.println(customer_order_no);
        System.out.println(seller_userName.getSeller_username());
        return null;
    }
}
