package com.example.resttemplate.repository;

import com.example.resttemplate.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ClientRepository extends JpaRepository<Client, Integer>, QuerydslPredicateExecutor<Client> {

    Page<Client> findAll(Pageable pageable);

}
