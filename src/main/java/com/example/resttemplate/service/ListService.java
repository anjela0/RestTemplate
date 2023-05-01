package com.example.resttemplate.service;

import com.example.resttemplate.model.List;
import com.example.resttemplate.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;

    public List save(List list) {
        return listRepository.save(list);
    }

}
