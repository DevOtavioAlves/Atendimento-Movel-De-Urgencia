package com.samu.sistema.api;

import com.samu.sistema.model.Atendimento;
import com.samu.sistema.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

         @RestController
         @RequestMapping("/api/atendimentos")
         public class AtendimentoApiController {

                  @Autowired
                  private AtendimentoRepository atendimentoRepository;

                  @GetMapping
                  public List<Atendimento> listarAtendimentos() {
                      
                           return atendimentoRepository.findAll();
                           
                  }

                  @GetMapping("/{id}")
                  public ResponseEntity<Atendimento> obterAtendimento(@PathVariable Long id) {
                      
                           return atendimentoRepository.findById(id)
                                    .map(ResponseEntity::ok)
                                    .orElse(ResponseEntity.notFound().build());
                           
                  }

                  @PostMapping
                  public Atendimento criarAtendimento(@RequestBody Atendimento atendimento) {
                      
                           atendimento.setDataHora(LocalDateTime.now());
                           
                           return atendimentoRepository.save(atendimento);
                  }

                  @PutMapping("/{id}")
                  public ResponseEntity<Atendimento> atualizarAtendimento(@PathVariable Long id, @RequestBody Atendimento atendimentoAtualizado) {
                      
                           return atendimentoRepository.findById(id)
                                    .map(atendimento -> {
                                             atendimento.setDescricao(atendimentoAtualizado.getDescricao());
                                             atendimento.setEndereco(atendimentoAtualizado.getEndereco());
                                             atendimento.setStatus(atendimentoAtualizado.getStatus());
                                             atendimento.setProfissionalNome(atendimentoAtualizado.getProfissionalNome());
                                             Atendimento atualizado = atendimentoRepository.save(atendimento);
                                             
                                             return ResponseEntity.ok(atualizado);
                                    })
                                    .orElse(ResponseEntity.notFound().build());
                  }

                  @DeleteMapping("/{id}")
                  public ResponseEntity<Void> excluirAtendimento(@PathVariable Long id) {
                      
                           if (atendimentoRepository.existsById(id)) {
                               
                                    atendimentoRepository.deleteById(id);
                                    
                                    return ResponseEntity.noContent().build();
                                    
                           }
                           
                           return ResponseEntity.notFound().build();
                           
                  }
         }
