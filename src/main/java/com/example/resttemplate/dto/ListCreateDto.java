package com.example.resttemplate.dto;

import com.example.resttemplate.model.ClientStatus;
import com.example.resttemplate.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListCreateDto {


    private String name;

    @ManyToOne
    private Task task;

}
