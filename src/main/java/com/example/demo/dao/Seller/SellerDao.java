package com.example.demo.dao.Seller;

import com.example.demo.model.Seller.SellerDetails;
import com.example.demo.model.Seller.SellerValidation;

import java.util.List;

public interface SellerDao {

    int insertSeller(SellerDetails sellerDetails);

    List<SellerDetails>selectALlSeller();

    String updateSellerByUsername(String seller_username,SellerDetails sellerDetails);

    String ValidateSeller(SellerValidation sellerValidation);

    String GetSellerDetails(String seller_username);
}
