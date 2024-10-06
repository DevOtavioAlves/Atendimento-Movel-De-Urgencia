package com.samu.sistema.controller;

import com.samu.sistema.model.Atendimento;
import com.samu.sistema.repository.InMemoryAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private InMemoryAtendimentoRepository atendimentoRepository;

    @GetMapping
    public String listarAtendimentos(Model model) {
        List<Atendimento> atendimentos = atendimentoRepository.findAll();
        model.addAttribute("atendimentos", atendimentos);
        return "atendimento-lista";
    }

    @GetMapping("/novo")
    public String novoAtendimento(Model model) {
        model.addAttribute("atendimento", new Atendimento());
        return "atendimento-form";
    }

    @PostMapping("/salvar")
    public String salvarAtendimento(@ModelAttribute Atendimento atendimento) {
        atendimento.setDataHora(LocalDateTime.now());
        atendimentoRepository.save(atendimento);
        return "redirect:/atendimentos";
    }

    @GetMapping("/excluir/{id}")
    public String excluirAtendimento(@PathVariable Long id) {
        atendimentoRepository.deleteById(id);
        return "redirect:/atendimentos";
    }
}
