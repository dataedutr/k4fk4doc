package org.example;

public class Order {

    private String customerId;

    private String category;

    private String itemName;

    private Integer quantity;

    private Double price;

    private String orderDate;

    public Order() {
    }

    public Order(String customerId, String category, String itemName, Integer quantity, Double price, String orderDate) {
        this.customerId = customerId;
        this.category = category;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerId='" + customerId + '\'' +
                ", category='" + category + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
