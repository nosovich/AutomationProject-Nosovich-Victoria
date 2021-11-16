package Pojo;

public class Content {

    Integer productID;
    String productName;
    Integer quantity;

    public Integer getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Content{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
