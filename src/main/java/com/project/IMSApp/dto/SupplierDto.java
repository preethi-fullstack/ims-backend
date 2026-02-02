package com.project.IMSApp.dto;

public class SupplierDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public SupplierDto() {
        System.out.println("SupplierDto object created.");
    }

    public SupplierDto(Long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;

        System.out.println("SupplierDto object initialized with values: " +
                "\nID: " + id +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nAddress: " + address);
    }

    // Getters & Setters with debug
    public Long getId() {
        System.out.println("GET ID → " + id);
        return id;
    }

    public void setId(Long id) {
        System.out.println("SET ID → " + id);
        this.id = id;
    }

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
