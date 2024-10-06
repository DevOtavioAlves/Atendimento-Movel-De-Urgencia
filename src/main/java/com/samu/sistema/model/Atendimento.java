package com.samu.sistema.model;

import java.time.LocalDateTime;

         public class Atendimento {
                  private Long id;
                  private String descricao;
                  private String endereco;
                  private LocalDateTime dataHora;
                  private String status;
                  private Long pacienteId;  // ID do paciente atendido
                  private Long profissionalId;  // ID do profissional responsável

                  private String pacienteNome;  // Nome do paciente
                  private String profissionalNome;  // Nome do profissional responsável

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
                  
                  public Long getPacienteId() {
                      
                        return pacienteId;
                        
                  }

                  public void setPacienteId(Long pacienteId) {
                      
                        this.pacienteId = pacienteId;
                        
                  }

                  public Long getProfissionalId() {
                      
                        return profissionalId;
                        
                  }

                  public void setProfissionalId(Long profissionalId) {
                      
                        this.profissionalId = profissionalId;
                        
                  }

                  public String getPacienteNome() {
                      
                        return pacienteNome;
                        
                  }

                  public void setPacienteNome(String pacienteNome) {
                      
                        this.pacienteNome = pacienteNome;
                        
                  }

                  public String getProfissionalNome() {
                      
                        return profissionalNome;
                        
                  }

                  public void setProfissionalNome(String profissionalNome) {
                      
                        this.profissionalNome = profissionalNome;
                        
                  }                                  
         }
