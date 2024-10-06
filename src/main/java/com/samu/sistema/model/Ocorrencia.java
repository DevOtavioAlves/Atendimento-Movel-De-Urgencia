package com.samu.sistema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

         @Entity
         public class Ocorrencia {
             
                  @Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
                  private Long id;
                  
                  private String descricao;
                  private String endereco;
                  private LocalDateTime dataHora;
                  private String status;
                  
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

                  public Paciente getPaciente() {
                      
                           return paciente;
                        
                  }

                  public void setPaciente(Paciente paciente) {
                      
                           this.paciente = paciente;
                           
                  }      
         }
