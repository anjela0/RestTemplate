package com.example.resttemplate.service;

import com.example.resttemplate.dto.ContactCreateDto;
import com.example.resttemplate.dto.ContactUpdateDto;
import com.example.resttemplate.model.Contact;
import com.example.resttemplate.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Optional<Contact> findById(int id) {
        return contactRepository.findById(id);
    }


    public void update(Contact contact) {
        save(Contact.builder()
                        .id(contact.getId())
                        .name(contact.getName())
                        .email(contact.getEmail())
                        .occupation(contact.getOccupation())
                        .phone(contact.getPhone())
                        .location(contact.getLocation())
                        .build());
    }

    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }
}
