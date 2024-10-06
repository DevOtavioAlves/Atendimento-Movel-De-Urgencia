package com.samu.sistema.controller;

import com.samu.sistema.model.Ocorrencia;
import com.samu.sistema.model.Paciente;
import com.samu.sistema.repository.OcorrenciaRepository;
import com.samu.sistema.repository.PacienteRepository;
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
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public String listarOcorrencias(Model model) {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        model.addAttribute("ocorrencias", ocorrencias);
        return "ocorrencia-lista";
    }

    @GetMapping("/novo")
    public String novaOcorrencia(Model model) {
                  List<Paciente> pacientes = pacienteRepository.findAll();
                  model.addAttribute("pacientes", pacientes);
                  model.addAttribute("ocorrencia", new Ocorrencia());
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
    
    @GetMapping("/buscar")
    public String buscarOcorrencias(@RequestParam("descricao") String descricao, Model model) {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findByDescricaoContaining(descricao);
        model.addAttribute("ocorrencias", ocorrencias);
        return "ocorrencia-lista"; // O nome da sua view para listar ocorrências
    }
}
