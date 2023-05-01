package com.example.resttemplate.repository;

import com.example.resttemplate.dto.ClientFilterDto;
import com.example.resttemplate.dto.TaskFilterDto;
import com.example.resttemplate.model.Client;
import com.example.resttemplate.model.QTask;
import com.example.resttemplate.model.Task;
import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CustomTaskRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Task> tasks(TaskFilterDto taskFilterDto) {
        QTask qTask = QTask.task;

        var jpaQuery = new JPAQuery(entityManager);

        JPAQueryBase from = jpaQuery.from(qTask);

        if(taskFilterDto.getTitle() != null && !taskFilterDto.getTitle().equals("")) {
            from.where(qTask.title.contains(taskFilterDto.getTitle()));
        }

        if(taskFilterDto.getDescription() != null && !taskFilterDto.getDescription().equals("")) {
            from.where(qTask.description.contains(taskFilterDto.getDescription()));
        }

        return from.fetch();
    }

}
