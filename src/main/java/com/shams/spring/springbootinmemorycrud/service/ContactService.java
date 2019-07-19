package com.shams.spring.springbootinmemorycrud.service;

import com.shams.spring.springbootinmemorycrud.model.Contact;
import com.shams.spring.springbootinmemorycrud.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private IContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    public void createNewContact(Contact contact) {
        try {
            if (contact.validate()) {
                contactRepository.save(contact);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).get();
    }
}
