package Pojo;

import java.util.List;

public class User {

    double orderID;
    String shopperName;
    String shopperEmail;
    List<Content> contents;
    Boolean orderCompleted;

    public double getOrderID() {
        return orderID;
    }

    public String getShopperName() {
        return shopperName;
    }

    public String getShopperEmail() {
        return shopperEmail;
    }

    public List<Content> getContents() {
        return contents;
    }

    public Boolean getOrderCompleted() {
        return orderCompleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "orderID=" + orderID +
                ", shopperName='" + shopperName + '\'' +
                ", shopperEmail='" + shopperEmail + '\'' +
                ", contents=" + contents +
                ", orderCompleted=" + orderCompleted +
                '}';
    }
}

