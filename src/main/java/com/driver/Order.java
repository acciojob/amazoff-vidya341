package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {

        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        int h = Integer.parseInt(deliveryTime.substring(0,2));
        int m = Integer.parseInt(deliveryTime.substring(3,4));
        this.id  = id;
        this.deliveryTime = (h*60)+m;
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
