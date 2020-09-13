package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.Invoice;
import com.infotech.fleetapp.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Integer id){
        return invoiceRepository.findById(id);
    }

    public void addNewInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public void updateInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public void removeInvoice(Integer id){
        invoiceRepository.deleteById(id);
    }
}
