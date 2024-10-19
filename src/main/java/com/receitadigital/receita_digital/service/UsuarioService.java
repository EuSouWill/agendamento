package com.receitadigital.receita_digital.service;

import com.receitadigital.receita_digital.model.Usuario;
import com.receitadigital.receita_digital.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            // Adicione um log aqui para ver o que está acontecendo
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
            throw e; // Repropague a exceção se necessário
        }
    }


    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
