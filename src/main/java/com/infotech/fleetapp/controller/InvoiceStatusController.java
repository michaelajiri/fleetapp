package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.InvoiceStatus;
import com.infotech.fleetapp.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    private final InvoiceStatusService invoiceStatusService;

    @Autowired
    public InvoiceStatusController(InvoiceStatusService invoiceStatusService) {
        this.invoiceStatusService = invoiceStatusService;
    }

    @RequestMapping(value = "/invoiceStatuses", method = RequestMethod.GET)
    public String invoiceStatusPage(Model model) {
        List<InvoiceStatus> listOfInvoiceStatuses = invoiceStatusService.getAllInvoiceStatuses();
        model.addAttribute("listOfInvoiceStatuses", listOfInvoiceStatuses);
        return "invoiceStatus";
    }

    @ResponseBody
    @RequestMapping(value = "/oneInvoiceStatus", method = RequestMethod.GET)
    public Optional<InvoiceStatus> getInvoiceStatusById(Integer id, Model model) {
        return invoiceStatusService.getInvoiceStatusById(id);
    }

    @RequestMapping(value = "/addNewInvoiceStatus", method = RequestMethod.POST)
    public String addNewInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusService.addNewInvoiceStatus(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "/editInvoiceStatus", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusService.updateInvoiceStatus(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "/deleteInvoiceStatus", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteInvoiceStatus(Integer id) {
        invoiceStatusService.removeInvoiceStatus(id);
        return "redirect:/invoiceStatuses";
    }
}
