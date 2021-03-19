package com.example.demo.api.Admin;

import com.example.demo.model.Admin.BrandDetails;
import com.example.demo.model.Admin.CategoryDetails;
import com.example.demo.model.Admin.ProductDetails;
import com.example.demo.service.Admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("api/v2/Admin")
@RestController
public class AdminController {
    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(path="/insertBrandTitle")
    public String addBrandTitle(@Valid @NotNull @RequestBody BrandDetails brandDetails){
        System.out.println("Inserting Brand");
        return  adminService.addBrandTitle(brandDetails);
    }

    @PostMapping(path="/insertCategoryTitle")
    public String addCategoryTitle(@Valid @NotNull @RequestBody CategoryDetails categoryDetails){
        return adminService.addCategoryTitle(categoryDetails);
    }

    @PostMapping(path="/insertProduct")
    public String addProduct(@Valid @NotNull @RequestBody ProductDetails productDetails){
        return adminService.addProduct(productDetails);
    }
    @GetMapping("/getMsg")
    public String greeting()
    {
        return "spring security example";
    }

}
