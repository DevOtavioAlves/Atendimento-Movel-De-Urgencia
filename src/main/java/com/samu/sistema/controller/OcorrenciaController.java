package com.samu.sistema.controller;

import com.samu.sistema.model.Ocorrencia;
import com.samu.sistema.model.Paciente;
import com.samu.sistema.repository.InMemoryOcorrenciaRepository;
import com.samu.sistema.repository.InMemoryPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

         @Controller
         @RequestMapping("/ocorrencias")
         public class OcorrenciaController {

                  @Autowired
                  private InMemoryOcorrenciaRepository ocorrenciaRepository;

                  @Autowired
                  private InMemoryPacienteRepository pacienteRepository;

                  @GetMapping
                  public String listarOcorrencias(Model model) {
                           List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
                           List<Paciente> pacientes = pacienteRepository.findAll();

                           // Atribuir o nome do paciente a cada ocorrência
                           for (Ocorrencia ocorrencia : ocorrencias) {
                               
                                    Paciente paciente = pacientes.stream()
                                             .filter(p -> p.getId().equals(ocorrencia.getPacienteId()))
                                             .findFirst()
                                             .orElse(null);
                                    
                                    if (paciente != null) {
                                        
                                             ocorrencia.setPacienteNome(paciente.getNome());
                                             
                                    }
                           }

                           model.addAttribute("ocorrencias", ocorrencias);
                           return "ocorrencia-lista";
                  }

                  @GetMapping("/novo")
                  public String novaOcorrencia(Model model) {
                      
                           model.addAttribute("ocorrencia", new Ocorrencia());
                           model.addAttribute("pacientes", pacienteRepository.findAll());
                           
                           return "ocorrencia-form";
                           
                    }

                  @PostMapping("/salvar")
                  public String salvarOcorrencia(@ModelAttribute Ocorrencia ocorrencia) {
                      
                           ocorrencia.setDataHora(LocalDateTime.now());
                           ocorrenciaRepository.save(ocorrencia);
                           
                           return "redirect:/ocorrencias";
                           
                  }

                  @GetMapping("/excluir/{id}")
                  public String excluirOcorrencia(@PathVariable Long id) {
                      
                           ocorrenciaRepository.deleteById(id);
                           
                           return "redirect:/ocorrencias";
                           
                  }
        }
