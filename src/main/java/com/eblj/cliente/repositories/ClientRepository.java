package com.eblj.cliente.repositories;

import com.eblj.cliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
