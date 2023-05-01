package com.example.resttemplate.mapper;

import com.example.resttemplate.dto.ClientCreateDto;
import com.example.resttemplate.dto.ClientResponseDto;
import com.example.resttemplate.dto.ClientUpdateDto;
import com.example.resttemplate.model.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client map(ClientCreateDto clientCreateDto);

    List<ClientResponseDto> map(List<Client> clients);

    Client map(ClientUpdateDto clientUpdateDto);

}
