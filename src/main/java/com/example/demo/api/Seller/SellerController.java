package com.example.demo.api.Seller;

import com.example.demo.model.Seller.*;
import com.example.demo.service.Seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    public SellerDetails GetSellerDetails(@PathVariable("seller_username")String seller_username)
    {
        return sellerService.getSellerDetails(seller_username);
    }

    //Inserting a new product-Seller
    @PostMapping(path = "/insertProduct")
    public void InsertProduct(@Valid @NotNull @RequestBody SellerProduct sellerProduct)
    {
        sellerService.InsertNewSellerProduct(sellerProduct);
    }

    // all products of a seller
    @GetMapping(path ="/all_products")
    public List<SellerProduct> GetAllSellerProducts(@Valid @NotNull @RequestBody Seller_UserName seller_userName)
    {
         return sellerService.GetAllSellerProducts(seller_userName);
    }

    //search product of the seller
    @GetMapping(path = "/seller_product_details/{product_name}")
    public List<SellerProduct> getProductSellerDetails(@PathVariable("product_name")String product_name,@Valid @NotNull @RequestBody Seller_UserName seller_username)
    {
        //return product details
       return sellerService.ProductDetails(product_name,seller_username);
    }
    // updating seller products
    @PutMapping(path = "/update_product_details/{product_name}")
    public void updateProductDetails(@PathVariable("product_name")String product_name,@Valid @NotNull @RequestBody SellerProductUpdate sellerProductUpdate)
    {
        sellerService.updateProduct(product_name,sellerProductUpdate);
    }
    //get all orders of the seller
    @GetMapping(path = "/all_orders")
    public List<Seller_Orders> all_orders(@Valid @NotNull @RequestBody Seller_UserName seller_userName)
    {
        //System.out.println(seller_userName.getSeller_username());
       return  sellerService.all_orders(seller_userName);
    }

    //search for specific product
    @GetMapping(path = "/search_product/{product_name}")
    public void search_product(@PathVariable("product_name") String product_name,@Valid @NotNull @RequestBody Seller_UserName seller_userName)
    {
        //return
    }

    //order details
    @GetMapping(path = "/order_details/{customer_order_no}")
    public void order_details(@PathVariable("customer_order_no")int customer_order_no,@Valid @NotNull @RequestBody  Seller_UserName seller_userName)
    {
        sellerService.get_order_details(customer_order_no,seller_userName);
    }

}
