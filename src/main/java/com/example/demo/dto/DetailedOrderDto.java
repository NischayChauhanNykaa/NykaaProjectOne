package com.example.demo.dto;

import java.util.List;

public class DetailedOrderDto {
    private long orderId;
    private List<DetailDto> orderDetails;

    private double amount;

    private double shippingCharge;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;

    private String email;

    private boolean shipped;

    public DetailedOrderDto() {
    }

    public DetailedOrderDto(long orderId, List<DetailDto> orderDetails, double amount, double shippingCharge, String name, String address, String city, String state, String zip, String country, String phone, String email, boolean shipped) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
        this.amount = amount;
        this.shippingCharge = shippingCharge;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.shipped = shipped;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<DetailDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<DetailDto> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
}
