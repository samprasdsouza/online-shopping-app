package com.example.demo.service.Seller;

import com.example.demo.dao.Seller.SellerDao;
import com.example.demo.model.Customer.CustomerDetails;
import com.example.demo.model.Seller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    private final SellerDao sellerDao;
    @Autowired
    public SellerService(@Qualifier("SellerModelPostgres") SellerDao sellerDao) {
        this.sellerDao = sellerDao;
    }

    public int addSeller(SellerDetails sellerDetails){
        return sellerDao.insertSeller(sellerDetails);
    }

    public String ValidateSeller(SellerValidation sellerValidation){
        return  sellerDao.ValidateSeller(sellerValidation);
    }

    public String updateSeller(String seller_username,SellerDetails sellerDetails)
    {
        return sellerDao.updateSellerByUsername(seller_username,sellerDetails);
    }

    public String getSellerDetails(String seller_username)
    {
        return sellerDao.GetSellerDetails(seller_username);
    }

    public String InsertNewSellerProduct(SellerProduct sellerProduct){
        return  sellerDao.InsertProduct(sellerProduct);
    }
    public String GetAllSellerProducts(Seller_UserName seller_userName)
    {
         return sellerDao.AllSellerProducts(seller_userName);
    }

    public  String ProductDetails(String ProductName,Seller_UserName seller_userName)
    {
        return sellerDao.getProductDetails(ProductName,seller_userName);
    }
    public String updateProduct(String ProductName, SellerProductUpdate sellerProductUpdate)
    {
        return sellerDao.updateProductDetails(ProductName,sellerProductUpdate);
    }

}
