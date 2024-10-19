package com.receitadigital.receita_digital.service;

import com.receitadigital.receita_digital.model.Agendamento;
import com.receitadigital.receita_digital.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento agendar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public boolean horarioDisponivel(LocalDateTime dataHora) {
        // Verifique se já existe um agendamento nesse horário
        return agendamentoRepository.findAll().stream()
                .noneMatch(agendamento -> agendamento.getDataHora().equals(dataHora));
    }

    // Outros métodos, como cancelar, confirmar, etc.
}
