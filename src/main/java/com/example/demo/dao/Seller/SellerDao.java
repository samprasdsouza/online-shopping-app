package com.example.demo.dao.Seller;

import com.example.demo.model.Seller.*;

import java.util.List;

public interface SellerDao {

    int insertSeller(SellerDetails sellerDetails);

    List<SellerDetails>selectALlSeller();

    String updateSellerByUsername(String seller_username,SellerDetails sellerDetails);

    String ValidateSeller(SellerValidation sellerValidation);

    String GetSellerDetails(String seller_username);

    String InsertProduct(SellerProduct sellerProduct);

    String AllSellerProducts(Seller_UserName seller_userName);

    String getProductDetails(String Product_name,Seller_UserName seller_userName);

    String updateProductDetails(String product_name, SellerProductUpdate sellerProductUpdate);

    String allOrders(Seller_UserName seller_userName);

    String order_details(int customer_order_no,Seller_UserName seller_userName);
}
