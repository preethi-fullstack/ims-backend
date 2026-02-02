
package com.project.IMSApp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;

    public Supplier() {
        System.out.println("Supplier entity created.");
    }

    public Long getId() { System.out.println("GET ID → " + id); return id; }
    public void setId(Long id) { System.out.println("SET ID → " + id); this.id = id; }

    public String getName() { System.out.println("GET NAME → " + name); return name; }
    public void setName(String name) { System.out.println("SET NAME → " + name); this.name = name; }

    public String getEmail() { System.out.println("GET EMAIL → " + email); return email; }
    public void setEmail(String email) { System.out.println("SET EMAIL → " + email); this.email = email; }

    public String getPhone() { System.out.println("GET PHONE → " + phone); return phone; }
    public void setPhone(String phone) { System.out.println("SET PHONE → " + phone); this.phone = phone; }

    public String getAddress() { System.out.println("GET ADDRESS → " + address); return address; }
    public void setAddress(String address) { System.out.println("SET ADDRESS → " + address); this.address = address; }
}
