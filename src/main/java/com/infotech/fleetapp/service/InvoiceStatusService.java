package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.InvoiceStatus;
import com.infotech.fleetapp.repo.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {

    private final InvoiceStatusRepository invoiceStatusRepository;

    @Autowired
    public InvoiceStatusService(InvoiceStatusRepository invoiceStatusRepository) {
        this.invoiceStatusRepository = invoiceStatusRepository;
    }

    public List<InvoiceStatus> getAllInvoiceStatuses() {
        return invoiceStatusRepository.findAll();
    }

    public Optional<InvoiceStatus> getInvoiceStatusById(Integer id) {
        return invoiceStatusRepository.findById(id);
    }

    public void addNewInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public void updateInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public void removeInvoiceStatus(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
