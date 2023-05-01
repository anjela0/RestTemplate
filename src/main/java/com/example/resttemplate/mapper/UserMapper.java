package com.example.resttemplate.mapper;

import com.example.resttemplate.dto.UserCreateDto;
import com.example.resttemplate.dto.UserResponseDto;
import com.example.resttemplate.dto.UserUpdateDto;
import com.example.resttemplate.model.User;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto map(User user);

    User map(UserUpdateDto userUpdateDto);

    User map(UserCreateDto userCreateDto);



}
