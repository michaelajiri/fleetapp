package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.Client;
import com.infotech.fleetapp.model.Invoice;
import com.infotech.fleetapp.model.InvoiceStatus;
import com.infotech.fleetapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceStatusService invoiceStatusService;
    private final ClientService clientService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, InvoiceStatusService invoiceStatusService,
                             ClientService clientService) {
        this.invoiceService = invoiceService;
        this.invoiceStatusService = invoiceStatusService;
        this.clientService = clientService;
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public String invoicePage(Model model) {
        List<Invoice> listOfInvoices = invoiceService.getAllInvoices();
        model.addAttribute("listOfInvoices", listOfInvoices);
        List<InvoiceStatus> listOfInvoiceStatuses = invoiceStatusService.getAllInvoiceStatuses();
        model.addAttribute("listOfInvoiceStatuses", listOfInvoiceStatuses);
        List<Client> listOfClients = clientService.getAllClients();
        model.addAttribute("listOfClients", listOfClients);
        return "invoice";
    }

    @ResponseBody
    @RequestMapping(value = "/oneInvoice", method = RequestMethod.GET)
    public Optional<Invoice> getInvoiceById(Integer id) {
        return invoiceService.getInvoiceById(id);
    }

    @RequestMapping(value = "/addNewInvoice", method = RequestMethod.POST)
    public String addNewInvoice(Invoice invoice) {
        invoiceService.addNewInvoice(invoice);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/editInvoice", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateInvoice(Invoice invoice) {
        invoiceService.updateInvoice(invoice);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/deleteInvoice", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String removeInvoice(Integer id) {
        invoiceService.removeInvoice(id);
        return "redirect:/clients";
    }
}
