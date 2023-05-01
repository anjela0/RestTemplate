package com.example.resttemplate.dto;

import com.example.resttemplate.model.ClientStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDeleteDto {

    private int id;

    private String name;

}
