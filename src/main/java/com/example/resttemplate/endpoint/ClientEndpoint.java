package com.example.resttemplate.endpoint;

import com.example.resttemplate.dto.*;
import com.example.resttemplate.mapper.ClientMapper;
import com.example.resttemplate.model.Client;
import com.example.resttemplate.repository.CustomClientRepo;
import com.example.resttemplate.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientEndpoint {

    private final ClientService clientService;

    private final ClientMapper clientMapper;

    private final CustomClientRepo customClientRepo;

    @PostMapping("/client")
    public ResponseEntity<?> save(@RequestBody ClientCreateDto clientCreateDto) {
        return ResponseEntity.ok(clientService.save(clientMapper.map(clientCreateDto)));
    }

//    @GetMapping("/clientSearch")
//    public ResponseEntity<List<ClientResponseDto>> search(@RequestBody ClientFilterDto clientFilterDto) {
//            return ResponseEntity.ok(clientMapper.map(customClientRepo.clients(clientFilterDto)));
//    }

    @PutMapping("/client")
    public ResponseEntity<?> update(@RequestBody ClientUpdateDto clientUpdateDto) {
        return ResponseEntity.ok(clientService.update(clientMapper.map(clientUpdateDto)));
    }

    @DeleteMapping("/client")
    public  ResponseEntity<?> delete(@RequestBody ClientDeleteDto clientDeleteDto) {
        if(clientService.findById(clientDeleteDto.getId()).isPresent()) {
            clientService.deleteById(clientDeleteDto.getId());
            return ResponseEntity.ok(clientDeleteDto.getName());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/client")
    public ResponseEntity<List<Client>> findAll(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size")Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int currentSize = size.orElse(5);

        return ResponseEntity.ok(clientService.findAll(PageRequest.of(currentPage - 1, currentSize)).getContent());

    }

}
