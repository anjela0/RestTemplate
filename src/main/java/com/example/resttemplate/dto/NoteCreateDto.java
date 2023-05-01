package com.example.resttemplate.dto;

import com.example.resttemplate.model.ClientStatus;
import com.example.resttemplate.model.NoteStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteCreateDto {

    private String title;

    private String description;

    private NoteStatus status;

}
