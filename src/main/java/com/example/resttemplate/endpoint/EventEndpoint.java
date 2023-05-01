package com.example.resttemplate.endpoint;

import com.example.resttemplate.dto.EventCreateDto;
import com.example.resttemplate.dto.EventResponseDto;
import com.example.resttemplate.mapper.EventMapper;
import com.example.resttemplate.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequiredArgsConstructor
public class EventEndpoint {

    private final EventService eventService;

    private final EventMapper eventMapper;

    @PostMapping("/event")
    public ResponseEntity<?> save(@RequestBody EventCreateDto eventCreateDto) throws ParseException {
        return ResponseEntity.ok(eventService.save(eventMapper.map(eventCreateDto)));
    }

}
