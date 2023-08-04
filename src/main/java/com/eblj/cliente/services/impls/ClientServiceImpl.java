package com.eblj.cliente.services.impls;

import com.eblj.cliente.dtos.ClientDTO;
import com.eblj.cliente.entities.Client;
import com.eblj.cliente.repositories.ClientRepository;
import com.eblj.cliente.services.ClientService;
import com.eblj.cliente.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository repository;

  @Override
  @Transactional(readOnly = true)
  public Page<ClientDTO> findAll(Pageable pageable) {
    Page<Client> clients = repository.findAll(pageable);
    return  clients.map(result -> new ClientDTO(result));
  }

  @Override
  @Transactional(readOnly = true)
  public ClientDTO findByid(Long id) {
    Client client = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado"));
    client.convertToCliet();
    return new ClientDTO(client);
  }

  @Override
  @Transactional
  public ClientDTO insert(ClientDTO dto) {
    Client client = new Client();
    copyDtoToEntity(dto,client);
    repository.save(client);
    return new ClientDTO(client);
  }

  @Override
  public ClientDTO update(Long id, ClientDTO dto) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
  private void copyDtoToEntity(ClientDTO dto, Client entity) {
    entity.setName(dto.getName());
    entity.setCpf(dto.getCpf());
    entity.setBirthDate(dto.getBirthDate());
    entity.setChildren(dto.getChildren());
    entity.setIncome(dto.getIncome());
  }
}
