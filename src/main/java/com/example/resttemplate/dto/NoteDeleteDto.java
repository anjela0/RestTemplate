package com.example.resttemplate.dto;

import com.example.resttemplate.model.NoteStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteDeleteDto {


    private int id;

    private String title;

}
