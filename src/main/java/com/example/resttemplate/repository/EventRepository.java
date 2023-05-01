package com.example.resttemplate.repository;

import com.example.resttemplate.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
