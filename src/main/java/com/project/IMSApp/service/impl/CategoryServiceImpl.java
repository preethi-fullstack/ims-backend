
package com.project.IMSApp.service.impl;

import com.project.IMSApp.dto.CategoryRequest;
import com.project.IMSApp.dto.CategoryDto;
import com.project.IMSApp.entity.Category;
import com.project.IMSApp.repository.CategoryRepository;
import com.project.IMSApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryRequest request) {

        System.out.println("=== SERVICE: CREATE CATEGORY ===");
        System.out.println("Checking if category name exists → " + request.getName());

        if (categoryRepository.existsByName(request.getName())) {
            System.out.println("Category name already exists: " + request.getName());
            throw new RuntimeException("Category name already exists!");
        }

        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        System.out.println("Saving category...");
        categoryRepository.save(category);
        System.out.println("Saved category with ID → " + category.getId());

        return new CategoryDto(category.getId(), category.getName(), category.getDescription());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {

        System.out.println("=== SERVICE: GET CATEGORY BY ID ===");
        System.out.println("Looking for category with ID → " + id);

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("Category not found for ID → " + id);
                    return new RuntimeException("Category not found");
                });

        System.out.println("Category found → " + category.getName());

        return new CategoryDto(category.getId(), category.getName(), category.getDescription());
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        System.out.println("=== SERVICE: GET ALL CATEGORIES ===");
        List<Category> categories = categoryRepository.findAll();
        System.out.println("Total categories found → " + categories.size());

        return categories.stream()
                .map(c -> {
                    System.out.println("Mapping category → " + c.getName());
                    return new CategoryDto(c.getId(), c.getName(), c.getDescription());
                })
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryRequest request) {

        System.out.println("=== SERVICE: UPDATE CATEGORY ===");
        System.out.println("Updating category with ID → " + id);

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        if (!category.getName().equals(request.getName()) &&
                categoryRepository.existsByName(request.getName())) {

            System.out.println("Category name conflict → " + request.getName());
            throw new RuntimeException("Category name already exists!");
        }

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        System.out.println("Saving updated category...");
        categoryRepository.save(category);

        return new CategoryDto(category.getId(), category.getName(), category.getDescription());
    }

    @Override
    public void deleteCategory(Long id) {

        System.out.println("=== SERVICE: DELETE CATEGORY ===");
        System.out.println("Deleting category with ID → " + id);

        if (!categoryRepository.existsById(id)) {
            System.out.println("Delete failed → Category does not exist");
            throw new RuntimeException("Category not found");
        }

        categoryRepository.deleteById(id);
        System.out.println("Category deleted successfully");
    }
}

