
package com.project.IMSApp.service;

import com.project.IMSApp.dto.ProductRequest;
import com.project.IMSApp.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductRequest request);
    ProductDto getProductById(Long id);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);
}
