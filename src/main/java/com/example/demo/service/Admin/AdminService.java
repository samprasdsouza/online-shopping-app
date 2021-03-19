package com.example.demo.service.Admin;

import com.example.demo.dao.Admin.AdminDao;
import com.example.demo.model.Admin.BrandDetails;
import com.example.demo.model.Admin.CategoryDetails;
import com.example.demo.model.Admin.ProductDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminDao adminDao;


    public AdminService(@Qualifier("AdminModelPostgres") AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public String addBrandTitle(BrandDetails brandDetails){
        return adminDao.insertBrand(brandDetails);
    }

    public String addCategoryTitle(CategoryDetails categoryDetails){
        return adminDao.insertCategory(categoryDetails);
    }

    public String addProduct(ProductDetails productDetails){
        return  adminDao.insertProduct(productDetails);
    }
}
