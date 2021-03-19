package com.example.demo.dao.Admin;


import com.example.demo.model.Admin.BrandDetails;
import com.example.demo.model.Admin.CategoryDetails;
import com.example.demo.model.Admin.ProductDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("AdminModelPostgres")
public class AdminDataAccessService implements AdminDao {

    private final JdbcTemplate jdbcTemplate;

    public AdminDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String insertBrand(BrandDetails brandDetails) {
        System.out.println("Adding A Brand");
        System.out.println(brandDetails.getBrand_title());
        System.out.println(brandDetails.getBrand_id());
        return null;
    }

    @Override
    public String insertCategory(CategoryDetails categoryDetails) {
        System.out.println("Adding A Category");
        System.out.println(categoryDetails.getCat_id());
        System.out.println(categoryDetails.getCat_title());
        return null;
    }

    @Override
    public String insertProduct(ProductDetails productDetails) {
        System.out.println("Inserting Product");
        System.out.println(productDetails.getProduct_id());
        System.out.println(productDetails.getProduct_brand());
        System.out.println(productDetails.getProduct_category());
        System.out.println(productDetails.getProduct_description());
        return null;
    }
}
