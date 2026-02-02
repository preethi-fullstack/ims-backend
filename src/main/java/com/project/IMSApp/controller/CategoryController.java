package com.project.IMSApp.controller;

import com.project.IMSApp.dto.CategoryRequest;
import com.project.IMSApp.dto.CategoryDto;
import com.project.IMSApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Create new category
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryRequest request) {

        System.out.println("=== CREATE CATEGORY REQUEST RECEIVED ===");
        System.out.println("Category Name: " + request.getName());
        System.out.println("Description: " + request.getDescription());

        CategoryDto created = categoryService.createCategory(request);

        System.out.println("Category Created: " + created);

        return ResponseEntity.ok(created);
    }

    // Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {

        System.out.println("=== GET CATEGORY BY ID REQUEST ===");
        System.out.println("Category ID: " + id);

        CategoryDto category = categoryService.getCategoryById(id);

        System.out.println("Category Found: " + category);

        return ResponseEntity.ok(category);
    }

    // Get all categories
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {

        System.out.println("=== GET ALL CATEGORIES REQUEST ===");

        List<CategoryDto> categories = categoryService.getAllCategories();

        System.out.println("Total Categories Found: " + categories.size());
        categories.forEach(cat -> System.out.println("Category: " + cat));

        return ResponseEntity.ok(categories);
    }

    // Update category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request) {

        System.out.println("=== UPDATE CATEGORY REQUEST ===");
        System.out.println("Category ID: " + id);
        System.out.println("New Name: " + request.getName());
        System.out.println("New Description: " + request.getDescription());

        CategoryDto updated = categoryService.updateCategory(id, request);

        System.out.println("Category Updated: " + updated);

        return ResponseEntity.ok(updated);
    }

    // Delete category
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {

        System.out.println("=== DELETE CATEGORY REQUEST ===");
        System.out.println("Deleting Category ID: " + id);

        categoryService.deleteCategory(id);

        System.out.println("Category deleted successfully.");

        return ResponseEntity.ok("Category deleted successfully");
    }
}
