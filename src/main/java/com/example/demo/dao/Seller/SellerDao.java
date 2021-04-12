package com.example.demo.dao.Seller;

import com.example.demo.model.Seller.*;

import java.util.List;

public interface SellerDao {

    String insertSeller(SellerDetails sellerDetails);

    List<SellerDetails>selectALlSeller();

    String updateSellerByUsername(String seller_username,SellerDetails sellerDetails);

    String ValidateSeller(SellerValidation sellerValidation);

    SellerDetails GetSellerDetails(String seller_username);

    String InsertProduct(SellerProduct sellerProduct);

    List<SellerProduct> AllSellerProducts(Seller_UserName seller_userName);

    List<SellerProduct> getProductDetails(String Product_name, Seller_UserName seller_userName);

    String updateProductDetails(String product_name, SellerProductUpdate sellerProductUpdate);

    List<Seller_Orders> allOrders(Seller_UserName seller_userName);

    String order_details(int customer_order_no,Seller_UserName seller_userName);
}
