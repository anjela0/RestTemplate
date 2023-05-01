package com.example.resttemplate.endpoint;

import com.example.resttemplate.dto.NoteCreateDto;
import com.example.resttemplate.dto.NoteDeleteDto;
import com.example.resttemplate.mapper.NoteMapper;
import com.example.resttemplate.model.Client;
import com.example.resttemplate.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class NoteEndpoint {

    private final NoteService noteService;

    private final NoteMapper noteMapper;

    @PostMapping("/note")
    public ResponseEntity<?> save(@RequestBody NoteCreateDto noteCreateDto) {
        return ResponseEntity.ok(noteService.save(noteMapper.map(noteCreateDto)));
    }

    @DeleteMapping("/note")
    public ResponseEntity<?> delete(@RequestBody NoteDeleteDto noteDeleteDto) {
        if(noteService.findById(noteDeleteDto.getId()).isPresent()) {
            noteService.deleteById(noteDeleteDto.getId());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
