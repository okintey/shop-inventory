package org.mycompany.shopinventory.service;

import lombok.RequiredArgsConstructor;
import org.mycompany.shopinventory.dto.Supplier;
import org.mycompany.shopinventory.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier updateSupplier(final Long id,
                                   final Supplier supplier) {
        return supplierRepository.findById(id).map(existingSupplier -> {
            existingSupplier.setName(supplier.getName());
            existingSupplier.setPhoneNumber(supplier.getPhoneNumber());
            existingSupplier.setEmail(supplier.getEmail());
            existingSupplier.setAdditionalInfo(supplier.getAdditionalInfo());
            return supplierRepository.save(existingSupplier);
        }).orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
