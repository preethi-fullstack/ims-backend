package com.project.IMSApp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    public Category() {
        System.out.println("Category entity created.");
    }

    public Long getId() {
        System.out.println("GET ID → " + id);
        return id;
    }

    public void setId(Long id) {
        System.out.println("SET ID → " + id);
        this.id = id;
    }

    public String getName() {
        System.out.println("GET NAME → " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("SET NAME → " + name);
        this.name = name;
    }

    public String getDescription() {
        System.out.println("GET DESCRIPTION → " + description);
        return description;
    }

    public void setDescription(String description) {
        System.out.println("SET DESCRIPTION → " + description);
        this.description = description;
    }
}
