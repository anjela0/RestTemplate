package com.example.resttemplate.mapper;

import com.example.resttemplate.dto.NoteCreateDto;
import com.example.resttemplate.model.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    Note map(NoteCreateDto noteCreateDto);

}
