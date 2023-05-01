package com.example.resttemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactUpdateDto {

    private int id;

    private String name;

    private String email;

    private String occupation;

    private String phone;

    private String location;

}
