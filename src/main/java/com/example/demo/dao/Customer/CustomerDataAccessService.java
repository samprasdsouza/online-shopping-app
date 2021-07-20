package com.example.demo.dao.Customer;

import com.example.demo.dao.Customer.CustomerDao;
import com.example.demo.helper.ApiValidation;
import com.example.demo.model.Customer.*;
import com.example.demo.model.Person.Person;
import com.example.demo.model.Product.Product_Details;
import com.example.demo.model.Seller.SellerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

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
    public List<Customer_Username> selectAllCustomer() {
        System.out.println("Selecting Customers");
        final String sql  = "Select customer_username from customer";
        List<Customer_Username> customer = jdbcTemplate.query(sql,(resultSet, i)->{
            String name =  resultSet.getString("customer_username");
            return new Customer_Username(name);
        });
        return customer;
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
        String customer_name = customerDetails.getCustomer_name();
        String customer_email =customerDetails.getCustomer_email();
        String customer_contact=customerDetails.getCustomer_contact();
        String customer_address=customerDetails.getCustomer_address();
        String customer_password=customerDetails.getCustomer_password();
        jdbcTemplate.update("UPDATE customer SET customer_name=?,customer_email=?,customer_contact=?,customer_address=?,customer_password=? Where customer_username=?",customer_name,customer_email,customer_contact,customer_address,customer_password,customer_username);
        System.out.println("Update Done");

        return null;
    }



    @Override
    public String ValidateCustomer(CustomerValidation customerValidation) {
       System.out.println(" Validating User Name and Password");

       System.out.println(customerValidation.getCustomer_username());
       System.out.println(customerValidation.getCustomer_password());
         //Query To Validate The UserName and Password
        String entered_username = customerValidation.getCustomer_username();
        String entered_password = customerValidation.getCustomer_password();
        // get password for username
        String original_password  = jdbcTemplate.queryForObject("select customer_password from customer where customer_username=? ",new Object[] { entered_username },String.class);
        System.out.println(original_password);
        if(entered_password.equals(original_password))
        {
            System.out.println("Customer Validated");
            return null;
        }
        System.out.println("Wrong Password");
        return null;
    }

    @Override
    public CustomerDetails GetCustomerDetails(String customer_username){
        System.out.println(customer_username);

        System.out.println("Executing Query");
        List<CustomerDetails> customers = jdbcTemplate.query("select * from customer where customer_username =?",
                new Object[]{customer_username}, (resultSet, i) -> {
                    return toCustomer(resultSet);
                });
//    System.out.println("returning NULL");
        if (customers.size() == 1) return customers.get(0);
        System.out.println("returning NULL");
        return null;
    }

    @Override
    public List<Customer_Cart> UserCart(Customer_Username customer_username) {
        System.out.println(customer_username.getCustomer_username());
        //query to get all cart of the user
        //

        int customer_id = jdbcTemplate.queryForObject("SELECT customer_id FROM customer WHERE customer_username=?",new Object[] { customer_username.getCustomer_username() },Integer.class);
        System.out.println(customer_id);
        //

        System.out.println("Executing Query to get all orders in cart");
        List<Customer_Cart> customer_cart = jdbcTemplate.query("select * from cart where customer_id =?",
                new Object[]{customer_id}, (resultSet, i) -> {
                    return toCustomer_Cart(resultSet);
                });
//    System.out.println("returning NULL");
        return customer_cart;
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
        String product_name = product_details.getProduct_name();
        System.out.println(product_details.getSeller_username());
        String seller_username = product_details.getSeller_username();
        int customer_id = jdbcTemplate.queryForObject("SELECT customer_id FROM customer WHERE customer_username=?",new Object[] { customer_username },Integer.class);
        int seller_id = jdbcTemplate.queryForObject("SELECT seller_id FROM seller WHERE seller_username=?",new Object[] { seller_username },Integer.class);
        int product_id = jdbcTemplate.queryForObject("SELECT product_id FROM products WHERE product_name=?",new Object[] { product_name },Integer.class);

        // if the quantity is 1 then delete the row
        int quatity_of_product =jdbcTemplate.queryForObject("SELECT quantity FROM cart WHERE customer_id=? AND seller_id=? AND product_id=? ",new Object[] { customer_id,seller_id,product_id },Integer.class);
        if(quatity_of_product==1)
        {
                //delete the entry
            jdbcTemplate.update("DELETE  FROM cart WHERE customer_id =? AND seller_id=? AND product_id=?",customer_id,seller_id,product_id);

        }
        else{
            //update the  quantity
            jdbcTemplate.update("UPDATE cart SET quantity =quantity-1 WHERE customer_id =? AND seller_id=? AND product_id=?",customer_id,seller_id,product_id);
        }



        return null;
    }

    @Override
    public List<Customer_Orders> allOrders(Customer_Username customer_username) {
        System.out.println(customer_username.getCustomer_username());
        //query to  get all the orders
        int customer_id = jdbcTemplate.queryForObject("SELECT customer_id FROM customer WHERE customer_username=?",new Object[] { customer_username.getCustomer_username() },Integer.class);

        System.out.println(customer_id);
        System.out.println("Executing Query to get all orders from orders table");
        List<Customer_Orders> customer_orders = jdbcTemplate.query("select * from order where customer_id =?",
                new Object[]{customer_id}, (resultSet, i) -> {
                    return toCustomer_Orders(resultSet);
                });
        return customer_orders;
    }

    @Override
    public String ordered_executed_successfully(String customer_username)
    {
        System.out.println(customer_username);
        //
        int customer_id = jdbcTemplate.queryForObject("SELECT customer_id FROM customer WHERE customer_username=?",new Object[] { customer_username },Integer.class);
        System.out.println(customer_id);

        int customer_order_n0 =jdbcTemplate.queryForObject("SELECT customer_order_no FROM customer WHERE customer_username=?",new Object[] { customer_username },Integer.class);
        System.out.println(customer_order_n0);


        // Insert the data into orders  from Cart
        System.out.println("Executing Query to get all orders in cart");
        List<Customer_Cart> customer_cart = jdbcTemplate.query("select * from cart where customer_id =?",
                new Object[]{customer_id}, (resultSet, i) -> {
                    return toCustomer_Cart_Ordered(resultSet,customer_order_n0);
                });
//    System.out.println("returning NULL");
        // update the order number
        System.out.println(customer_cart.size());
        System.out.println(customer_cart.get(0));
        int n =customer_cart.size();

        for(int i=0;i<n;i++)
        {

            //
            int seller_id = jdbcTemplate.queryForObject("SELECT seller_id FROM seller WHERE seller_username=?",new Object[] { customer_cart.get(i).getSeller_username() },Integer.class);
            System.out.println(seller_id);
            System.out.println(customer_id);

            int product_id = customer_cart.get(i).getProduct_id();

            int quantity = customer_cart.get(i).getQuantity();

            int unit_price = customer_cart.get(i).getProduct_unit_price();
//            String sql_query ="insert into order(seller_id) VALUES(?)";
//            jdbcTemplate.update(sql_query,seller_id);
            jdbcTemplate.update("INSERT INTO orders(seller_id,customer_id,product_id,quantity,customer_order_no,product_unit_price) VALUES(?,?,?,?,?,?)", seller_id,customer_id,product_id,quantity,customer_order_n0,unit_price );

        }
        jdbcTemplate.update("UPDATE customer SET customer_order_no =customer_order_no + 1 WHERE customer_id =? ",customer_id);

        jdbcTemplate.update("delete FROM cart WHERE customer_id=?", customer_id );


        return null;
    }
    private CustomerDetails toCustomer(ResultSet resultSet) throws SQLException {
        CustomerDetails customerDetails = new CustomerDetails();
        System.out.println("Creating a new object");
        //set the values

        customerDetails.setCustomer_name(resultSet.getString("customer_name"));
        customerDetails.setCustomer_email(resultSet.getString("customer_email"));
        customerDetails.setCustomer_contact(resultSet.getString("customer_contact"));
        customerDetails.setCustomer_address(resultSet.getString("customer_address"));
        customerDetails.setCustomer_password(resultSet.getString("customer_password"));
        customerDetails.setCustomer_username(resultSet.getString("customer_username"));

        return customerDetails;
    }
    private Customer_Cart toCustomer_Cart(ResultSet resultSet)throws SQLException{
        Customer_Cart customer_cart = new Customer_Cart();
        System.out.println("Creating new object");

        int customer_id = resultSet.getInt("customer_id");
        String customer_username = jdbcTemplate.queryForObject("SELECT customer_username FROM customer WHERE customer_id=?",new Object[] { customer_id },String.class);;
        customer_cart.setCustomer_username(customer_username);
        int seller_id =  resultSet.getInt("seller_id");
        String seller_username = jdbcTemplate.queryForObject("SELECT seller_username FROM seller WHERE seller_id=?",new Object[] { seller_id },String.class);
        customer_cart.setSeller_username(seller_username);

        customer_cart.setQuantity(resultSet.getInt("quantity"));
        customer_cart.setProduct_id(resultSet.getInt("product_id"));
        customer_cart.setProduct_unit_price(resultSet.getInt("product_unit_price"));

        return customer_cart;
    }

    private Customer_Orders toCustomer_Orders(ResultSet resultSet)throws SQLException{
        Customer_Orders customer_orders = new Customer_Orders();
        System.out.println("Creating new object");
        int customer_id = resultSet.getInt("customer_id");
        String customer_username =  jdbcTemplate.queryForObject("SELECT customer_username FROM customer WHERE customer_id=?",new Object[] { customer_id },String.class);
        customer_orders.setCustomer_username(customer_username);
        int seller_id =  resultSet.getInt("seller_id");
        String seller_username = jdbcTemplate.queryForObject("SELECT seller_username FROM seller WHERE seller_id=?",new Object[] { seller_id },String.class);
        customer_orders.setSeller_Username(seller_username);
        int product_id = resultSet.getInt("product_id");
        String product_name = jdbcTemplate.queryForObject("SELECT product_name FROM products WHERE product_id=?",new Object[] { product_id },String.class);

        customer_orders.setProduct_name(product_name);
        int quantity = resultSet.getInt("quantity");
        customer_orders.setQuantity(quantity);
        int customer_order_no = resultSet.getInt("customer_order_no");
        customer_orders.setCustomer_order_no(customer_order_no);
        int product_unit_price = resultSet.getInt("product_unit_price");
        customer_orders.setProduct_unit_price(product_unit_price);

        return customer_orders;
    }

    private Customer_Cart toCustomer_Cart_Ordered(ResultSet resultSet, int customer_order_no)throws SQLException{
        Customer_Cart customer_cart = new Customer_Cart();
        int customer_id = resultSet.getInt("customer_id");
        String customer_username = jdbcTemplate.queryForObject("SELECT customer_username FROM customer WHERE customer_id=?",new Object[] { customer_id },String.class);;
        customer_cart.setCustomer_username(customer_username);
        int seller_id =  resultSet.getInt("seller_id");
        String seller_username = jdbcTemplate.queryForObject("SELECT seller_username FROM seller WHERE seller_id=?",new Object[] { seller_id },String.class);
        customer_cart.setSeller_username(seller_username);

        customer_cart.setQuantity(resultSet.getInt("quantity"));
        int quantity = resultSet.getInt("quantity");
        customer_cart.setProduct_id(resultSet.getInt("product_id"));
        int product_id = resultSet.getInt("product_id");
        customer_cart.setProduct_unit_price(resultSet.getInt("product_unit_price"));
        int product_unit_price = resultSet.getInt("product_unit_price");
        System.out.println(seller_id);
        System.out.println(customer_id);

        System.out.println(quantity);

        System.out.println(product_id);
        System.out.println(product_unit_price);
        System.out.println(customer_order_no);



        System.out.println("reached");


        return customer_cart;
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