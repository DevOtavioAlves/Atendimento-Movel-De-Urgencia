package com.samu.sistema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.samu.sistema.model.Paciente;
import jakarta.persistence.*;
import java.time.LocalDateTime;

         @Entity
         public class Atendimento {
             
                  @Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
                  private Long id;
                  
                  private String descricao;
                  private String endereco;
                  private LocalDateTime dataHora;
                  private String status;
                  
                  private String profissionalNome;

                  @ManyToOne
                  @JoinColumn(name = "paciente_id")
                  @JsonIgnore
                  private Paciente paciente;

                  public Long getId() {
                           return id;
                  }

                  public void setId(Long id) {
                      
                        this.id = id;
                        
                  }

                  public String getDescricao() {
                      
                        return descricao;
                        
                  }

                  public void setDescricao(String descricao) {
                      
                        this.descricao = descricao;
                        
                  }

                  public String getEndereco() {
                      
                        return endereco;
                        
                  }

                  public void setEndereco(String endereco) {
                      
                        this.endereco = endereco;
                        
                  }

                  public LocalDateTime getDataHora() {
                      
                        return dataHora;
                        
                  }

                  public void setDataHora(LocalDateTime dataHora) {
                      
                        this.dataHora = dataHora;
                        
                  }

                  public String getStatus() {
                      
                        return status;
                        
                  }

                  public void setStatus(String status) {
                      
                        this.status = status;
                        
                  }

                  public String getProfissionalNome() {
                      
                           return profissionalNome;
                           
                  }

                  public void setProfissionalNome(String profssionalNome) {
                      
                           this.profissionalNome = profssionalNome;
                           
                  }
                  

                  public Paciente getPaciente() {
                      
                           return paciente;
                           
                  }

                  public void setPaciente(Paciente paciente) {
                      
                           this.paciente = paciente;
                           
                  }   
         }
