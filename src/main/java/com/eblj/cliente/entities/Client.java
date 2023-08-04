package com.eblj.cliente.entities;

import com.eblj.cliente.dtos.ClientDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Entity
@Table(name = "tb_client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String cpf;
  private Double income;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")//salva no banco com utc
  private LocalDate birthDate;
  private Integer children;

  public Client(){}

  public Client(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.income = income;
    this.birthDate = birthDate;
    this.children = children;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Double getIncome() {
    return income;
  }

  public void setIncome(Double income) {
    this.income = income;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Integer getChildren() {
    return children;
  }

  public void setChildren(Integer children) {
    this.children = children;
  }

  public ClientDTO convertToCliet(){
    ClientDTO clientDTO = new ClientDTO();
    BeanUtils.copyProperties(this,clientDTO);
    return clientDTO;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Client client = (Client) o;

    return id.equals(client.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
