
package com.project.IMSApp.service;

import com.project.IMSApp.dto.SupplierRequest;
import com.project.IMSApp.dto.SupplierDto;

import java.util.List;

public interface SupplierService {
    SupplierDto createSupplier(SupplierRequest request);
    SupplierDto getSupplierById(Long id);
    List<SupplierDto> getAllSuppliers();
    SupplierDto updateSupplier(Long id, SupplierRequest request);
    void deleteSupplier(Long id);
}
