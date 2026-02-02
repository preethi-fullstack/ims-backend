
package com.project.IMSApp.dto;

public class CategoryRequest {
    private String name;
    private String description;

    public CategoryRequest() {}

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
