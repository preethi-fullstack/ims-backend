
package com.project.IMSApp.service;

import com.project.IMSApp.dto.CategoryRequest;
import com.project.IMSApp.dto.CategoryDto;
import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryRequest request);
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(Long id, CategoryRequest request);
    void deleteCategory(Long id);
}
