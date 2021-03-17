package com.example.demo.api.Seller;

import com.example.demo.model.Seller.SellerDetails;
import com.example.demo.model.Seller.SellerValidation;
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

}
