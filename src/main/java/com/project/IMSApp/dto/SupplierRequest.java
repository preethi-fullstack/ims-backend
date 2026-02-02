package com.project.IMSApp.dto;

public class SupplierRequest {
    private String name;
    private String email;
    private String phone;
    private String address;

    public SupplierRequest() {
        System.out.println("SupplierRequest object created.");
    }

    // Getters & Setters with debug
    public String getName() {
        System.out.println("GET Name → " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("SET Name → " + name);
        this.name = name;
    }

    public String getEmail() {
        System.out.println("GET Email → " + email);
        return email;
    }

    public void setEmail(String email) {
        System.out.println("SET Email → " + email);
        this.email = email;
    }

    public String getPhone() {
        System.out.println("GET Phone → " + phone);
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("SET Phone → " + phone);
        this.phone = phone;
    }

    public String getAddress() {
        System.out.println("GET Address → " + address);
        return address;
    }

    public void setAddress(String address) {
        System.out.println("SET Address → " + address);
        this.address = address;
    }
}
