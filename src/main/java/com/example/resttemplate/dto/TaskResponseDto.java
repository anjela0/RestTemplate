package com.example.resttemplate.dto;

import com.example.resttemplate.model.TaskStatus;
import com.example.resttemplate.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponseDto {

    private int id;

    private String title;

    private String description;

    private Date deadline;

    private TaskStatus status;

    private User user;

}
