package com.eblj.cliente.controllers;

import com.eblj.cliente.dtos.ClientDTO;
import com.eblj.cliente.services.impls.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

  @Autowired
  private ClientServiceImpl service;

  @GetMapping
  public ResponseEntity<Page<ClientDTO>> findAll(@PageableDefault(size = 10,page = 0,sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
  //  o service já retorna uma page de clienteDto
  //  Page<ClientDTO> clientDTOPage = service.findAll(pageable);
    return ResponseEntity.ok(service.findAll(pageable));
  }

  @GetMapping("/{id}")
  @Transactional(readOnly = true)
  public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
    return ResponseEntity.ok(service.findByid(id));
  }

  @Transactional
  @PostMapping
  public ResponseEntity<ClientDTO> insert( @Valid @RequestBody ClientDTO dto){
    return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
  }

  @Transactional
  @PutMapping("/{id}")
  public ResponseEntity<ClientDTO> update( @PathVariable Long id,@Valid @RequestBody ClientDTO dto){
    return ResponseEntity.ok(service.update(id,dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

}
