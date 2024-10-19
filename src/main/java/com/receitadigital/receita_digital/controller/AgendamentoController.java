package com.receitadigital.receita_digital.controller;

import com.receitadigital.receita_digital.model.Agendamento;
import com.receitadigital.receita_digital.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public Agendamento agendar(@RequestBody Agendamento agendamento) {
        return agendamentoService.agendar(agendamento);
    }

    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoService.listarTodos();
    }

    // Outros endpoints para confirmar e cancelar agendamentos
}
