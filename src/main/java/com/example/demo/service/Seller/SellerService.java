package com.example.demo.service.Seller;

import com.example.demo.dao.Seller.SellerDao;
import com.example.demo.model.Customer.CustomerDetails;
import com.example.demo.model.Seller.SellerDetails;
import com.example.demo.model.Seller.SellerValidation;
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
}
