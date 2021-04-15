package com.example.demo.dao.Seller;


import com.example.demo.model.Seller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.helper.ApiValidation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

@Repository("SellerModelPostgres")
public class SellerDataAccessService  implements SellerDao{
    @Autowired
    private ApiValidation apiValidation;
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public SellerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public String insertSeller(SellerDetails sellerDetails) {
         System.out.println("Inserted Seller");
         System.out.println(sellerDetails.getSeller_name());
        System.out.println(sellerDetails.getSeller_email());
        System.out.println(sellerDetails.getSeller_contact());
        System.out.println(sellerDetails.getSeller_address());
        System.out.println(sellerDetails.getSeller_password());
        System.out.println(sellerDetails.getSeller_username());
        //Insert Seller
        String seller_username =sellerDetails.getSeller_username();
        int val  = jdbcTemplate.queryForObject("select count(*) from seller  where seller_username=? ",new Object[] { seller_username },Integer.class);
        System.out.println(val);
        if(val == 1) {
            return apiValidation.NewUserNameFull();
        }
        jdbcTemplate.update("INSERT INTO seller(seller_name,seller_email,seller_contact,seller_address,seller_password,seller_username) VALUES(?,?,?,?,?,?)",
                    sellerDetails.getSeller_name(), sellerDetails.getSeller_email(), sellerDetails.getSeller_contact(),
                    sellerDetails.getSeller_address(), sellerDetails.getSeller_password(), sellerDetails.getSeller_username());
        return apiValidation.NewUserSuccess();


    }

    @Override
    public List<SellerDetails> selectALlSeller() {
        return null;
    }

    @Override
    public String updateSellerByUsername(String seller_username, SellerDetails sellerDetails) {
        System.out.println(seller_username);
        System.out.println(sellerDetails.getSeller_name());
        System.out.println(sellerDetails.getSeller_email());
        System.out.println(sellerDetails.getSeller_contact());
        System.out.println(sellerDetails.getSeller_address());
        System.out.println(sellerDetails.getSeller_password());
        System.out.println(sellerDetails.getSeller_username());
        // update the details
        jdbcTemplate.update("UPDATE seller SET seller_name=?,seller_email=?,seller_contact=?,seller_address=?,seller_password=? WHERE seller_username=? ",
                sellerDetails.getSeller_name(), sellerDetails.getSeller_email(), sellerDetails.getSeller_contact(),
                sellerDetails.getSeller_address(), sellerDetails.getSeller_password(), sellerDetails.getSeller_username());
        System.out.println("User Updated");
        return null;
    }

    @Override
    public String ValidateSeller(SellerValidation sellerValidation) {
         System.out.println("Validating Seller User_name and Password");

        System.out.println(sellerValidation.getSeller_username());
        System.out.println(sellerValidation.getSeller_password());
        String entered_username = sellerValidation.getSeller_username();
        String entered_password = sellerValidation.getSeller_password();
        // get password for username
        String orignal_password  = jdbcTemplate.queryForObject("select seller_password from seller where seller_username=? ",new Object[] { entered_username },String.class);
        System.out.println(orignal_password);
        if(entered_password.equals(orignal_password))
        {
            System.out.println("User Validated");
            return null;
        }
        System.out.println("Wrong Password");
        return null;
    }

    @Override
    public SellerDetails GetSellerDetails(String seller_username) {
        System.out.println(seller_username);
        List<SellerDetails> sellers = jdbcTemplate.query("SELECT * FROM seller WHERE seller_username=?",
                new Object[]{seller_username}, (resultSet, i) -> {
            return toSeller(resultSet);
        });

        if(sellers.size()==1)return  sellers.get(0);
        System.out.println("returning NULL");
        return null;
    }

    @Override
    public String InsertProduct(SellerProduct sellerProduct) {
        System.out.println(sellerProduct.getSeller_id());
        int seller_id = sellerProduct.getSeller_id();
        System.out.println(sellerProduct.getProduct_id());
        int product_id = sellerProduct.getProduct_id();
        System.out.println(sellerProduct.getProduct_price());
        int product_price = sellerProduct.getProduct_price();
        System.out.println(sellerProduct.getProduct_image_path());
        String product_image_path= sellerProduct.getProduct_image_path();

        // query to insert product
        // check if already exists ??
            int count_of_seller_product =jdbcTemplate.queryForObject("select count(*) from seller_product where seller_id=? AND  product_id=? ",new Object[] { seller_id , product_id },Integer.class);
            if(count_of_seller_product ==1)
            {
                //insert
                jdbcTemplate.update("INSERT INTO seller_product(seller_id,product_id,product_price,product_image_path) VALUES(?,?,?,?)" ,seller_id,product_id,product_price,product_image_path);
                System.out.println("product  insert");
                return null;
            }
            System.out.println("product already exits");
        return null;
    }

    @Override
    public String AllSellerProducts(Seller_UserName seller_userName) {
        System.out.println(seller_userName.getSeller_username());
        //query for getting all the seller products
        return null;
    }

    @Override
    public String getProductDetails(String Product_name, Seller_UserName seller_userName) {
        System.out.println(Product_name);
        System.out.println(seller_userName.getSeller_username());
        //
        return null;
    }

    @Override
    public String updateProductDetails(String product_name, SellerProductUpdate sellerProductUpdate) {
        System.out.println(product_name);
        String seller_username = sellerProductUpdate.seller_username();
        System.out.println(sellerProductUpdate.getProduct_price());
        int product_price = sellerProductUpdate.getProduct_price();
        System.out.println(sellerProductUpdate.getProduct_image_path());
        String  product_image_path = sellerProductUpdate.getProduct_image_path();

        int product_id = jdbcTemplate.queryForObject("SELECT product_id FROM product WHERE product_name=?",new Object[] { product_name },Integer.class) ;
        int seller_id = jdbcTemplate.queryForObject("SELECT seller_id FROM seller WHERE seller_username=?",new Object[] { seller_username },Integer.class);
        jdbcTemplate.update("UPDATE seller_product SET product_price=?,product_image_path=? WHERE   seller_id=? AND product_id=?",product_price,product_image_path,seller_id,product_id);

        System.out.println("seller Products details updated ");
        //query to update products

        return null;
    }

    @Override
    public String allOrders(Seller_UserName seller_userName) {
        System.out.println(seller_userName.getSeller_username());
        return null;
    }

    @Override
    public String order_details(int customer_order_no, Seller_UserName seller_userName) {
        System.out.println(customer_order_no);
        System.out.println(seller_userName.getSeller_username());
        return null;
    }

    private SellerDetails toSeller(ResultSet resultSet) throws SQLException{
        SellerDetails sellerDetails = new SellerDetails();
        System.out.println("Creating a new object");
        //set the values

        sellerDetails.setSeller_name(resultSet.getString("seller_name"));
        sellerDetails.setSeller_email(resultSet.getString("seller_email"));
        sellerDetails.setSeller_contact(resultSet.getString("seller_contact"));
        sellerDetails.setSeller_address(resultSet.getString("seller_address"));
        sellerDetails.setSeller_password(resultSet.getString("seller_password"));
        sellerDetails.setSeller_username(resultSet.getString("seller_username"));

        return sellerDetails;
    }
}
