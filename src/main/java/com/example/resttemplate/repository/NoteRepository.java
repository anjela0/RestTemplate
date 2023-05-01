package com.example.resttemplate.repository;

import com.example.resttemplate.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
