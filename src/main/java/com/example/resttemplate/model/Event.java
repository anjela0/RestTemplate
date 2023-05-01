package com.example.resttemplate.model;

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
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventTo;

    private String description;

}
