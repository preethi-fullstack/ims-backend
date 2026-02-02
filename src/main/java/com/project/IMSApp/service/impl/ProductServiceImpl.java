
package com.project.IMSApp.service.impl;

import com.project.IMSApp.dto.ProductRequest;
import com.project.IMSApp.dto.ProductDto;
import com.project.IMSApp.entity.Category;
import com.project.IMSApp.entity.Product;
import com.project.IMSApp.repository.CategoryRepository;
import com.project.IMSApp.repository.ProductRepository;
import com.project.IMSApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDto createProduct(ProductRequest request) {

        System.out.println("=== SERVICE: CREATE PRODUCT ===");

        if (request.getCategoryId() == null) {
            System.out.println("Category ID is NULL — cannot create product");
            throw new RuntimeException("Category ID must not be null");
        }

        System.out.println("Fetching Category ID → " + request.getCategoryId());
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> {
                    System.out.println("Category NOT FOUND for ID → " + request.getCategoryId());
                    return new RuntimeException("Category not found");
                });

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCategory(category);

        System.out.println("Saving product...");
        productRepository.save(product);
        System.out.println("Product saved with ID → " + product.getId());

        return mapToDto(product);
    }

    @Override
    public ProductDto getProductById(Long id) {
        System.out.println("=== SERVICE: GET PRODUCT ===");
        System.out.println("Product ID → " + id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("Product NOT FOUND for ID → " + id);
                    return new RuntimeException("Product not found");
                });

        System.out.println("Product found → " + product.getName());
        return mapToDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {

        System.out.println("=== SERVICE: GET ALL PRODUCTS ===");

        List<Product> list = productRepository.findAll();

        System.out.println("Total products found → " + list.size());

        return list.stream()
                .map(p -> {
                    System.out.println("Mapping product → " + p.getName());
                    return mapToDto(p);
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long id, ProductRequest request) {

        System.out.println("=== SERVICE: UPDATE PRODUCT ===");
        System.out.println("Product ID → " + id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        System.out.println("Updating product fields...");

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCategory(category);

        productRepository.save(product);

        System.out.println("Product updated successfully!");

        return mapToDto(product);
    }

    @Override
    public void deleteProduct(Long id) {

        System.out.println("=== SERVICE: DELETE PRODUCT ===");
        System.out.println("Deleting Product ID → " + id);

        if (!productRepository.existsById(id)) {
            System.out.println("Product does not exist → " + id);
            throw new RuntimeException("Product not found");
        }

        productRepository.deleteById(id);

        System.out.println("Product deleted successfully.");
    }

    private ProductDto mapToDto(Product product) {
        System.out.println("Mapping Product to DTO → " + product.getName());
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getId(),
                product.getCategory().getName()
        );
    }
}

