package com.example.resttemplate.mapper;

import com.example.resttemplate.dto.EventCreateDto;
import com.example.resttemplate.model.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event map(EventCreateDto eventCreateDto);

}
