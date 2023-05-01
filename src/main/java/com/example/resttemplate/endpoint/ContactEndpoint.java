package com.example.resttemplate.endpoint;

import com.example.resttemplate.dto.ContactCreateDto;
import com.example.resttemplate.dto.ContactDeleteDto;
import com.example.resttemplate.dto.ContactResponseDto;
import com.example.resttemplate.dto.ContactUpdateDto;
import com.example.resttemplate.mapper.ContactMapper;
import com.example.resttemplate.model.Contact;
import com.example.resttemplate.security.CurrentUser;
import com.example.resttemplate.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ContactEndpoint {

    private final ContactService contactService;

    private final ContactMapper contactMapper;

    @PostMapping("/contact")
    public ResponseEntity<?> save(@RequestBody ContactCreateDto contactCreateDto, @AuthenticationPrincipal CurrentUser currentUser) {
        log.info("endpoint /contact called by {}", currentUser.getUser().getEmail());
        return ResponseEntity.ok(contactService.save(contactMapper.map(contactCreateDto)));
    }

    @PutMapping("/contact")
    public ResponseEntity<?> update(@RequestBody ContactUpdateDto contactUpdateDto) {
        if (contactService.findById(contactUpdateDto.getId()).isPresent()) {
            contactService.update(contactMapper.map(contactUpdateDto));
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/contact")
    public ResponseEntity<?> deleteById(@RequestBody ContactDeleteDto contactDeleteDto) {
        if(contactService.findById(contactDeleteDto.getId()).isPresent()) {
            contactService.deleteById(contactDeleteDto.getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
