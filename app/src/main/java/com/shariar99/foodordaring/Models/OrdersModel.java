package com.shariar99.foodordaring.Models;


public class OrdersModel {
    int orderImage;
    String soldName,orderNum,orderprice;

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldName() {
        return soldName;
    }

    public void setSoldName(String soldName) {
        this.soldName = soldName;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public OrdersModel(int orderImage, String soldName, String orderNum, String orderprice) {
        this.orderImage = orderImage;
        this.soldName = soldName;
        this.orderNum = orderNum;
        this.orderprice = orderprice;
    }
}
