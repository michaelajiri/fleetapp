package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.Contact;
import com.infotech.fleetapp.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Integer id){
        return contactRepository.findById(id);
    }

    public void addNewContact(Contact contact){
        contactRepository.save(contact);
    }

    public void updateContact(Contact contact){
        contactRepository.save(contact);
    }

    public void removeContact(Integer id){
        contactRepository.deleteById(id);
    }
}
