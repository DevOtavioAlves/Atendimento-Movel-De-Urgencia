package com.samu.sistema.api;

import com.samu.sistema.model.Ocorrencia;
import com.samu.sistema.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaApiController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping
    public List<Ocorrencia> listarOcorrencias() {
        return ocorrenciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> obterOcorrencia(@PathVariable Long id) {
        return ocorrenciaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ocorrencia criarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        ocorrencia.setDataHora(LocalDateTime.now());
        return ocorrenciaRepository.save(ocorrencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> atualizarOcorrencia(@PathVariable Long id, @RequestBody Ocorrencia ocorrenciaAtualizada) {
        return ocorrenciaRepository.findById(id)
                .map(ocorrencia -> {
                    ocorrencia.setDescricao(ocorrenciaAtualizada.getDescricao());
                    ocorrencia.setEndereco(ocorrenciaAtualizada.getEndereco());
                    ocorrencia.setStatus(ocorrenciaAtualizada.getStatus());
                    Ocorrencia atualizado = ocorrenciaRepository.save(ocorrencia);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirOcorrencia(@PathVariable Long id) {
        if (ocorrenciaRepository.existsById(id)) {
            ocorrenciaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
