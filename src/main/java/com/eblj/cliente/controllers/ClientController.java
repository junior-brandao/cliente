package com.eblj.cliente.controllers;

import com.eblj.cliente.dtos.ClientDTO;
import com.eblj.cliente.services.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
