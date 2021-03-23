package com.example.demo.api.Seller;

import com.example.demo.model.Seller.*;
import com.example.demo.service.Seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("api/v1/Seller")
@RestController
public class SellerController {

    @Autowired
    private  final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    //Registering A new Seller
    @PostMapping(path = "/registerNewSeller")
    public void addSeller(@Valid @NotNull @RequestBody SellerDetails sellerDetails)
    {
            System.out.println("Inserting Seller");

        sellerService.addSeller(sellerDetails);
    }

    //Validating A Existing Seller
    @PostMapping(path = "/ValidateSeller")
    public void ValidateSeller(@Valid @NotNull @RequestBody SellerValidation sellerValidation){
        System.out.println("Validating Seller");
        sellerService.ValidateSeller(sellerValidation);
    }

    // Updating Seller Details
    @PutMapping(path = "{seller_username}")
    public void updateSeller(@PathVariable("seller_username")String seller_username,@Valid @NotNull @RequestBody SellerDetails sellerDetails)
    {
        sellerService.updateSeller(seller_username,sellerDetails);
    }

    //Getting Seller Details by UserName
    @GetMapping(path = "{seller_username}")
    public void GetSellerDetails(@PathVariable("seller_username")String seller_username)
    {
        sellerService.getSellerDetails(seller_username);
    }

    //Inserting a new product-Seller
    @PostMapping(path = "/insertProduct")
    public void InsertProduct(@Valid @NotNull @RequestBody SellerProduct sellerProduct)
    {
        sellerService.InsertNewSellerProduct(sellerProduct);
    }

    // all products of a seller
    @GetMapping(path ="/all_products")
    public void GetAllSellerProducts(@Valid @NotNull @RequestBody Seller_UserName seller_userName)
    {
         sellerService.GetAllSellerProducts(seller_userName);
    }

    @GetMapping(path = "/seller_product_details/{product_name}")
    public void getProductSellerDetails(@PathVariable("product_name")String product_name,@Valid @NotNull @RequestBody Seller_UserName seller_username)
    {
        sellerService.ProductDetails(product_name,seller_username);
    }
    // updating seller products
    @PutMapping(path = "/update_product_details/{product_name}")
    public void updateProductDetails(@PathVariable("product_name")String product_name,@Valid @NotNull @RequestBody SellerProductUpdate sellerProductUpdate)
    {
        sellerService.updateProduct(product_name,sellerProductUpdate);
    }
}
