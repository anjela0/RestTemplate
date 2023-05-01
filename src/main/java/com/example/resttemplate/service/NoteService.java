package com.example.resttemplate.service;

import com.example.resttemplate.model.Note;
import com.example.resttemplate.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public Optional<Note> findById(int id) {
        return noteRepository.findById(id);
    }

    public void deleteById(int id) {
        noteRepository.deleteById(id);
    }
}
