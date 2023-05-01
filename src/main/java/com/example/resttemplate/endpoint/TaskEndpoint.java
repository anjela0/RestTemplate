package com.example.resttemplate.endpoint;

import com.example.resttemplate.dto.TaskFilterDto;
import com.example.resttemplate.dto.TaskResponseDto;
import com.example.resttemplate.mapper.TaskMapper;
import com.example.resttemplate.repository.CustomTaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TaskEndpoint {

    private final CustomTaskRepo customTaskRepo;

    private final TaskMapper taskMapper;

    @GetMapping("/task")
    public ResponseEntity<List<TaskResponseDto>> search(@RequestBody TaskFilterDto taskFilterDto) {
        return ResponseEntity.ok(taskMapper.map(customTaskRepo.tasks(taskFilterDto)));
    }

}
