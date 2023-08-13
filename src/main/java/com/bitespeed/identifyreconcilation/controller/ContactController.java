package com.bitespeed.identifyreconcilation.controller;

import com.bitespeed.identifyreconcilation.model.Contact;
import com.bitespeed.identifyreconcilation.model.ContactRequest;
import com.bitespeed.identifyreconcilation.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContactController {


    @Autowired
    private ContactService contactService;

    @PostMapping("/identify")
    public ResponseEntity<Contact> saveUser(@RequestBody ContactRequest contactRequest) throws Exception {
        try {
            Contact saveContact = contactService.saveContact(contactRequest);
            return new ResponseEntity<>(saveContact, HttpStatus.OK);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<Contact> getContactByEmailId(@PathVariable String email) {
        Contact contact = contactService.findByEmail(email);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contactList = contactService.findAll();
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }
}
