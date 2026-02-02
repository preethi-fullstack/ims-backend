
package com.project.IMSApp.service.impl;

import com.project.IMSApp.dto.SupplierRequest;
import com.project.IMSApp.dto.SupplierDto;
import com.project.IMSApp.entity.Supplier;
import com.project.IMSApp.repository.SupplierRepository;
import com.project.IMSApp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public SupplierDto createSupplier(SupplierRequest request) {
        System.out.println("=== SERVICE: CREATE SUPPLIER ===");

        Supplier supplier = new Supplier();
        supplier.setName(request.getName());
        supplier.setEmail(request.getEmail());
        supplier.setPhone(request.getPhone());
        supplier.setAddress(request.getAddress());

        System.out.println("Saving supplier...");
        supplierRepository.save(supplier);
        System.out.println("Supplier saved with ID: " + supplier.getId());

        return mapToDto(supplier);
    }

    @Override
    public SupplierDto getSupplierById(Long id) {
        System.out.println("=== SERVICE: GET SUPPLIER BY ID ===");
        System.out.println("Supplier ID: " + id);

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("Supplier not found for ID: " + id);
                    return new RuntimeException("Supplier not found");
                });

        System.out.println("Supplier found: " + supplier.getName());
        return mapToDto(supplier);
    }

    @Override
    public List<SupplierDto> getAllSuppliers() {
        System.out.println("=== SERVICE: GET ALL SUPPLIERS ===");

        List<Supplier> list = supplierRepository.findAll();
        System.out.println("Total suppliers: " + list.size());

        return list.stream()
                .map(s -> {
                    System.out.println("Mapping supplier: " + s.getName());
                    return mapToDto(s);
                })
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDto updateSupplier(Long id, SupplierRequest request) {
        System.out.println("=== SERVICE: UPDATE SUPPLIER ===");
        System.out.println("Supplier ID: " + id);

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        supplier.setName(request.getName());
        supplier.setEmail(request.getEmail());
        supplier.setPhone(request.getPhone());
        supplier.setAddress(request.getAddress());

        System.out.println("Updating supplier...");
        supplierRepository.save(supplier);
        System.out.println("Supplier updated successfully");

        return mapToDto(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        System.out.println("=== SERVICE: DELETE SUPPLIER ===");
        System.out.println("Deleting supplier ID: " + id);

        if (!supplierRepository.existsById(id)) {
            System.out.println("Supplier not found for ID: " + id);
            throw new RuntimeException("Supplier not found");
        }

        supplierRepository.deleteById(id);
        System.out.println("Supplier deleted successfully");
    }

    private SupplierDto mapToDto(Supplier supplier) {
        System.out.println("Mapping supplier to DTO: " + supplier.getName());
        return new SupplierDto(
                supplier.getId(),
                supplier.getName(),
                supplier.getEmail(),
                supplier.getPhone(),
                supplier.getAddress()
        );
    }
}
