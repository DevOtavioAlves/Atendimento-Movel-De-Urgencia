package com.samu.sistema.repository;

import com.samu.sistema.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

         public interface PacienteRepository extends JpaRepository<Paciente, Long> {
                  List<Paciente> findByNomeContaining(String nome);
         }
