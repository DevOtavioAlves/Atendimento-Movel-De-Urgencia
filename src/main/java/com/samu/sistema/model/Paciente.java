package com.samu.sistema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.samu.sistema.model.Ocorrencia;
import jakarta.persistence.*;
import java.util.List;

         @Entity
         public class Paciente {
             
                  @Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
                  private Long id;
                  
                  private String nome;
                  private String endereco;
                  private String telefone;
                  
                  @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
                  @JsonIgnore
                  private List<Ocorrencia> ocorrencias;

                  @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
                  @JsonIgnore
                  private List<Atendimento> atendimentos;

                  public Long getId() {
                      
                        return id;
                        
                  }

                  public void setId(Long id) {
                      
                        this.id = id;
                        
                  }

                  public String getNome() {
                      
                        return nome;
                        
                  }

                  public void setNome(String nome) {
                      
                        this.nome = nome;
                        
                  }

                  public String getEndereco() {
                      
                        return endereco;
                        
                  }

                  public void setEndereco(String endereco) {
                      
                        this.endereco = endereco;
                        
                  }

                  public String getTelefone() {
                      
                        return telefone;
                        
                  }

                  public void setTelefone(String telefone) {
                      
                           this.telefone = telefone;
                        
                  }

                  public List<Ocorrencia> getOcorrencias() {
                      
                           return ocorrencias;
                           
                  }

                  public void setOcorrencias(List<Ocorrencia> ocorrencias) {
                      
                           this.ocorrencias = ocorrencias;
                           
                  }

                  public List<Atendimento> getAtendimentos() {
                      
                           return atendimentos;
                           
                  }

                  public void setAtendimentos(List<Atendimento> atendimentos) {
                      
                           this.atendimentos = atendimentos;
                           
                  }
                  
         }
