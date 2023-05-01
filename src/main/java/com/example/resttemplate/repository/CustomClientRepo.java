package com.example.resttemplate.repository;

import com.example.resttemplate.dto.ClientFilterDto;
import com.example.resttemplate.model.Client;
import com.example.resttemplate.model.QClient;
import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CustomClientRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Client> clients(ClientFilterDto clientFilterDto) {
        QClient qClient = QClient.client;

        var jpaQuery = new JPAQuery(entityManager);

        JPAQueryBase from = jpaQuery.from(qClient);

        if(clientFilterDto.getName() != null && !clientFilterDto.getName().equals("")) {
            from.where(qClient.name.contains(clientFilterDto.getName()));
        }

        if(clientFilterDto.getStatus() != null) {
            from.where(qClient.status.eq(clientFilterDto.getStatus()));
        }
        return from.fetch();
    }

}
