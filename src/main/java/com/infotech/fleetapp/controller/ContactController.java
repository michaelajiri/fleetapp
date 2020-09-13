package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.Contact;
import com.infotech.fleetapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contactPage(Model model) {
        List<Contact> listOfContacts = contactService.getAllContacts();
        model.addAttribute("listOfContacts", listOfContacts);
        return "contact";
    }

    @ResponseBody
    @RequestMapping(value = "/oneContact", method = RequestMethod.GET)
    public Optional<Contact> getContactById(Integer id) {
        return contactService.getContactById(id);
    }

    @RequestMapping(value = "/addNewContact", method = RequestMethod.POST)
    public String addNewContact(Contact contact) {
        contactService.addNewContact(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/editContact", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateContact(Contact contact) {
        contactService.updateContact(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/deleteContact", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String removeContact(Integer id) {
        contactService.removeContact(id);
        return "redirect:/contacts";
    }
}
