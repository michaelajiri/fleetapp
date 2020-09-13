package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.Supplier;
import com.infotech.fleetapp.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Integer id){
        return supplierRepository.findById(id);
    }

    public void addNewSupplier(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void updateSupplier(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void removeSupplier(Integer id){
        supplierRepository.deleteById(id);
    }
}
