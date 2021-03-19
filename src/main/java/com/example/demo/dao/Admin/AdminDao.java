package com.example.demo.dao.Admin;

import com.example.demo.model.Admin.BrandDetails;
import com.example.demo.model.Admin.CategoryDetails;
import com.example.demo.model.Admin.ProductDetails;

public interface AdminDao {

    String insertBrand(BrandDetails brandDetails);

    String insertCategory(CategoryDetails categoryDetails);

    String insertProduct(ProductDetails productDetails);
}
