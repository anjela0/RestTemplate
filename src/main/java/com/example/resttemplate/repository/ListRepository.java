package com.example.resttemplate.repository;

import com.example.resttemplate.model.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List, Integer> {
}
