package org.example;

public class Account {
    private Integer customerId;
    private String customerName;

    private String searchItem;

    public Account() {
    }

    public Account(Integer customerId, String customerName, String searchItem) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.searchItem = searchItem;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }
}
