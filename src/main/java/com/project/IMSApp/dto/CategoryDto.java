package com.project.IMSApp.dto;

public class CategoryDto {
    private Long id;
    private String name;
    private String description;

    public CategoryDto() {
        System.out.println("CategoryDto created (empty)");
    }

    public CategoryDto(Long id, String name, String description) {
        System.out.println("CategoryDto created with values → ID: " + id + ", Name: " + name);
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        System.out.println("CategoryDto GET ID → " + id);
        return id;
    }

    public void setId(Long id) {
        System.out.println("CategoryDto SET ID → " + id);
        this.id = id;
    }

    public String getName() {
        System.out.println("CategoryDto GET NAME → " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("CategoryDto SET NAME → " + name);
        this.name = name;
    }

    public String getDescription() {
        System.out.println("CategoryDto GET DESCRIPTION → " + description);
        return description;
    }

    public void setDescription(String description) {
        System.out.println("CategoryDto SET DESCRIPTION → " + description);
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryDto{id=" + id + ", name='" + name + "', description='" + description + "'}";
    }
}
