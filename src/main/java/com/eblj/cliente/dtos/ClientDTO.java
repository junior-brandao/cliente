package com.eblj.cliente.dtos;

import com.eblj.cliente.entities.Client;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ClientDTO {

  @NotBlank(message = "Campo deve ser preenchido")
  @Size(min = 3,max = 45, message = "Campo nome deve conter no mínimo {min} e no máximo {max} caracteres")
  private String name;
  @NotBlank(message = "Campo deve ser preenchido")
  @Size(min = 11, message = "Campo nome deve conter no mínimo {min} digitus")
  private String cpf;
  @PastOrPresent(message = "A data de nascimento deve ser anterior a data atual.")
  private LocalDate birthDate;
  @PositiveOrZero(message = "Valor do campo informado deve ser maior ou igual a 0")
  @NotNull(message = "Campo deve ser preenchido")
  private Integer children;

  @Positive(message = "Valor deve ser maior que 0")
  @NotNull(message = "Campo deve ser preenchido")
  private Double income;

  public ClientDTO(){}

  public ClientDTO(String name, String cpf, LocalDate birthDate, Integer children, Double income) {
    this.name = name;
    this.cpf = cpf;
    this.birthDate = birthDate;
    this.children = children;
    this.income = income;
  }

  public ClientDTO(Client entity) {
    name = entity.getName();
    cpf = entity.getCpf();
    birthDate = entity.getBirthDate();
    children = entity.getChildren();
    income = entity.getIncome();
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


  public Double getIncome() {
    return income;
  }

  public void setIncome(Double income) {
    this.income = income;
  }
}
