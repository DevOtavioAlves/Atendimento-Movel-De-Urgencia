package com.samu.sistema.repository;

import com.samu.sistema.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

         public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
                  List<Atendimento> findByProfissionalNomeContaining(String nome);
         }
