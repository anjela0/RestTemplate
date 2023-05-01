package com.example.resttemplate.mapper;

import com.example.resttemplate.dto.ContactCreateDto;
import com.example.resttemplate.dto.ContactDeleteDto;
import com.example.resttemplate.dto.ContactUpdateDto;
import com.example.resttemplate.model.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {


    Contact map(ContactCreateDto contactCreateDto);

    Contact map(ContactUpdateDto contactUpdateDto);

    Contact map(ContactDeleteDto contactDeleteDto);

}
