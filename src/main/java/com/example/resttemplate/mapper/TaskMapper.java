package com.example.resttemplate.mapper;

import com.example.resttemplate.dto.TaskResponseDto;
import com.example.resttemplate.model.Task;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    List<TaskResponseDto> map(List<Task> task);

}
