package com.samu.sistema.repository;

import com.samu.sistema.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

         public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
             
                  List<Ocorrencia> findByDescricaoContaining(String descricao);
                  
         }
