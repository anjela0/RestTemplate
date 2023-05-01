package com.example.resttemplate.mapper;

import com.example.resttemplate.dto.ListCreateDto;
import com.example.resttemplate.model.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListMapper {

    List map(ListCreateDto listCreateDto);

}
