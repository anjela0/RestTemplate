package com.example.resttemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoDto {

    private int id;

    private int userId;

    private String title;

    private boolean completed;

}
