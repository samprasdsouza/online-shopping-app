package com.example.demo.model.Seller;

public class Seller_Orders {
    private int order_id;
    private int seller_id;
    private int customer_id;
    private String customer_username;
    private int product_id;
    private String product_name;
    private int quantity;
    private int customer_order_no;
    private int product_unit_price;

    public Seller_Orders(){

    }
    //set Methods
    public void setOrder_id(int order_id)
    {
        this.order_id = order_id;
    }
    public void setSeller_id(int seller_id){
        this.seller_id = seller_id;
    }
    public void setCustomer_id(int customer_id){
        this.customer_id = customer_id;
    }
    public void setCustomer_username(String customer_username){
        this.customer_username = customer_username;
    }
    public void setProduct_id(int product_id){
        this.product_id = product_id;
    }
    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setCustomer_order_no(int customer_order_no){
        this.customer_order_no = customer_order_no;
    }
    public void setProduct_unit_price(int product_unit_price){
        this.product_unit_price = product_unit_price;
    }
}
