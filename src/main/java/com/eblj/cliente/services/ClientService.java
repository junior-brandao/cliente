package com.eblj.cliente.services;

import com.eblj.cliente.dtos.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

   Page<ClientDTO> findAll(Pageable pageable);
   ClientDTO findByid(Long id);
   ClientDTO insert(ClientDTO dto);
   ClientDTO update(Long id, ClientDTO dto);
   void delete(Long id);

}
