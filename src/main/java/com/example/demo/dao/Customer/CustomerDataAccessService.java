package com.example.demo.dao.Customer;

import com.example.demo.dao.Customer.CustomerDao;
import com.example.demo.helper.ApiValidation;
import com.example.demo.model.Customer.CustomerDetails;
import com.example.demo.model.Customer.CustomerValidation;
import com.example.demo.model.Customer.Customer_Cart;
import com.example.demo.model.Customer.Customer_Username;
import com.example.demo.model.Product.Product_Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("CustomerModelPostgres")
public class CustomerDataAccessService implements CustomerDao {

    @Autowired
    private ApiValidation apiValidation;
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CustomerDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public String insertCustomer(CustomerDetails customerDetails) {
        System.out.println("Adding New Customer");
        System.out.println(customerDetails.getCustomer_name());
        System.out.println(customerDetails.getCustomer_email());
        System.out.println(customerDetails.getCustomer_contact());
        System.out.println(customerDetails.getCustomer_address());
        System.out.println(customerDetails.getCustomer_password());
        System.out.println(customerDetails.getCustomer_username());
//
        String name =customerDetails.getCustomer_username();
        int val  = jdbcTemplate.queryForObject("select count(*) from customer where customer_username=? ",new Object[] { name },Integer.class);
        System.out.println(val);
        if(val == 1)
            return apiValidation.NewUserNameFull();
        else
            jdbcTemplate.update("INSERT INTO customer(customer_name,customer_email,customer_contact,customer_address,customer_password,customer_username) VALUES(?,?,?,?,?,?)",
                    customerDetails.getCustomer_name(),customerDetails.getCustomer_email(),customerDetails.getCustomer_contact(),
                    customerDetails.getCustomer_address(),customerDetails.getCustomer_password(),customerDetails.getCustomer_username());
        return apiValidation.NewUserSuccess();

    }

    @Override
    public List<CustomerDetails> selectAllCustomer() {
        return null;
    }

    @Override
    public int deleteCustomerByUsername(CustomerDetails customerDetails) {

        return 0;
    }

    @Override
    public String updateCustomerByUsername(String customer_username,CustomerDetails customerDetails) {
        System.out.println("Updating Customer Data");


        System.out.println(customerDetails.getCustomer_email());
        System.out.println(customerDetails.getCustomer_email());
        //Update Customer

        return null;
    }



    @Override
    public String ValidateCustomer(CustomerValidation customerValidation) {
       System.out.println(" Validating User Name and Password");

       System.out.println(customerValidation.getCustomer_username());
       System.out.println(customerValidation.getCustomer_password());
         //Query To Validate The UserName and Password

        return null;
    }

    @Override
    public String GetCustomerDetails(String customer_username){
        System.out.println(customer_username);

        return null;
    }

    @Override
    public String UserCart(Customer_Username customer_username) {
        System.out.println(customer_username.getCustomer_username());
        //query to get all cart of the user
        return null;
    }

    @Override
    public String InsertToCart(Customer_Cart customer_cart) {
//        System.out.println(customer_cart.getCustomer_username());
        String customer_username = customer_cart.getCustomer_username();
//        System.out.println(customer_cart.getSeller_username());
        String seller_username = customer_cart.getSeller_username();
//        System.out.println(customer_cart.getProduct_id());
        int product_id = customer_cart.getProduct_id();
        //Insert into cart
        //get customer
            int customer_id = jdbcTemplate.queryForObject("SELECT customer_id FROM customer WHERE customer_username=?",new Object[] { customer_username },Integer.class);
            System.out.println(customer_id);
        //get seller id
            int seller_id = jdbcTemplate.queryForObject("SELECT seller_id FROM seller WHERE seller_username=?",new Object[] { seller_username },Integer.class);
        // get product unit price
            int  product_unit_price = jdbcTemplate.queryForObject("SELECT product_price FROM seller_product WHERE seller_id=? AND product_id=?",new Object[] { seller_id ,product_id},Integer.class);
        //check if present
        int count  = jdbcTemplate.queryForObject("select count(*) from cart where customer_id=? AND seller_id=? AND product_id=? ",new Object[] { customer_id , seller_id , product_id },Integer.class);
        System.out.println(count);
        if(count == 1) {
            jdbcTemplate.update("UPDATE cart SET quantity =quantity+1 WHERE customer_id =? AND seller_id=? AND product_id=?",customer_id,seller_id,product_id);
        }
        else{
            //insert and update
            jdbcTemplate.update("INSERT INTO cart(customer_id,seller_id,product_id,product_unit_price) VALUES(?,?,?,?)", customer_id ,seller_id,product_id,product_unit_price );
            jdbcTemplate.update("UPDATE cart SET quantity =quantity+1 WHERE customer_id =? AND seller_id=? AND product_id=?",customer_id,seller_id,product_id);
        }
        return null;
    }

    @Override
    public String DeleteFromCart(String customer_username, Product_Details product_details) {
        System.out.println(customer_username);
        System.out.println(product_details.getProduct_name());

        System.out.println(product_details.getSeller_username());
        return null;
    }

    @Override
    public String allOrders(Customer_Username customer_username) {
        System.out.println(customer_username.getCustomer_username());
        //query to  get all the orders

        return null;
    }

}
//{
//        "customer_name":"sam",
//        "customer_email":"samprasdsouza02@gmail.com",
//        "customer_contact":"9819955913",
//        "customer_address":"mumbai",
//        "customer_password":"Lazarus",
//        "customer_username":"dsouza_sam"
//        }