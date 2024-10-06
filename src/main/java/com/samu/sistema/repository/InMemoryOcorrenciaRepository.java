package com.samu.sistema.repository;

import com.samu.sistema.model.Ocorrencia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

         @Repository
         public class InMemoryOcorrenciaRepository {
             
                  private List<Ocorrencia> ocorrencias = new ArrayList<>();
                  private AtomicLong idGenerator = new AtomicLong(1);

                  // Retorna todas as ocorrências
                  public List<Ocorrencia> findAll() {

                           return ocorrencias;

                  }

                  // Salva uma nova ocorrência ou atualiza uma existente
                  public Ocorrencia save(Ocorrencia ocorrencia) {
                    
                  if (ocorrencia.getId() == null) {
                        
                           ocorrencia.setId(idGenerator.getAndIncrement());
                        
                  }
                    
                  ocorrencias.removeIf(o -> o.getId().equals(ocorrencia.getId()));
                  ocorrencias.add(ocorrencia);
                    
                  return ocorrencia;
                    
                  }

                  // Retorna uma ocorrência por ID
                  public Optional<Ocorrencia> findById(Long id) {
                      
                           return ocorrencias.stream().filter(o -> o.getId().equals(id)).findFirst();
                           
                  }

                  // Exclui uma ocorrência pelo ID
                  public void deleteById(Long id) {
                      
                           ocorrencias.removeIf(o -> o.getId().equals(id));
                           
                  }
         }
