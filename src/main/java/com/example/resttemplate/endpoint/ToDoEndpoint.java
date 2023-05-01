package com.example.resttemplate.endpoint;

import com.example.resttemplate.dto.ToDoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ToDoEndpoint {

    private final RestTemplate restTemplate;

    @GetMapping("/todo")
    public ResponseEntity<List<ToDoDto>> getAllTodos() {

        ResponseEntity<ToDoDto[]> forEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/", ToDoDto[].class);
        if(forEntity.hasBody()) {
            ToDoDto[] todos = forEntity.getBody();
            return ResponseEntity.ok(Arrays.asList(todos));
        }
        return ResponseEntity.notFound().build();
    }

}
