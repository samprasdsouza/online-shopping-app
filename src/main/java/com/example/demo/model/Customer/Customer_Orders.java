package com.example.demo.model.Customer;

public class Customer_Orders {
    private String seller_username;
    private String customer_username;
    private String product_name;
    private  int quantity ;
    private  int customer_order_no;
    private  int product_unit_price;

    public Customer_Orders(){

    }

    public void setSeller_Username(String seller_username)
    {
        this.seller_username = seller_username;
    }
    public void setCustomer_username(String customer_username)
    {
        this.customer_username = customer_username;
    }

    public void setProduct_name(String product_name)
    {
        this.product_name = product_name;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public void setCustomer_order_no(int customer_order_no)
    {
        this.customer_order_no =customer_order_no;
    }
    public void setProduct_unit_price(int product_unit_price)
    {
        this.product_unit_price = product_unit_price;
    }

}
