package com.example.resttemplate.endpoint;

import com.example.resttemplate.dto.ListCreateDto;
import com.example.resttemplate.mapper.ListMapper;
import com.example.resttemplate.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ListEndpoint {

    private final ListService listService;

    private final ListMapper listMapper;

    @PostMapping("/list")
    public ResponseEntity<?> save(@RequestBody ListCreateDto listCreateDto) {
        return ResponseEntity.ok(listService.save(listMapper.map(listCreateDto)));
    }

}
