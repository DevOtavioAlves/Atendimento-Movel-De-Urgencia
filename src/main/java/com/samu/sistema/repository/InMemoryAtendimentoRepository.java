package com.samu.sistema.repository;

import com.samu.sistema.model.Atendimento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryAtendimentoRepository {
    private List<Atendimento> atendimentos = new ArrayList<>();
    private AtomicLong idGenerator = new AtomicLong(1);

    // Retorna todos os atendimentos
    public List<Atendimento> findAll() {
        return atendimentos;
    }

    // Salva um novo atendimento ou atualiza um existente
    public Atendimento save(Atendimento atendimento) {
        if (atendimento.getId() == null) {
            atendimento.setId(idGenerator.getAndIncrement());
        }
        atendimentos.removeIf(a -> a.getId().equals(atendimento.getId()));
        atendimentos.add(atendimento);
        return atendimento;
    }

    // Retorna um atendimento por ID
    public Optional<Atendimento> findById(Long id) {
        return atendimentos.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    // Exclui um atendimento pelo ID
    public void deleteById(Long id) {
        atendimentos.removeIf(a -> a.getId().equals(id));
    }
}
