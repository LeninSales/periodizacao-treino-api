package periodizacao.treino.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import periodizacao.treino.dto.UsuarioDto;
import periodizacao.treino.service.UsuarioService;
import periodizacao.treino.models.UsuarioModel;


import java.util.List;
import java.util.NoSuchElementException;

@Component
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    public UsuarioModel criarUsuario(UsuarioDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dados do usuario não informados.");
        }
        return service.salvaUsuario(dto);
    }

    public List<UsuarioModel> listarUsuarios() {
        List<UsuarioModel> usuarios = service.listaUsuarios();
        if (usuarios.isEmpty()) {
            throw new NoSuchElementException("Nenhum usuário encontrado.");
        }
        return usuarios;
    }

    public UsuarioModel buscarUmUsuario(Integer id) {
        return service.pegaUmUsuario(id);
    }

    public UsuarioModel atualizarUsuario(Integer id, UsuarioDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dados do usuario não informados.");
        }
        return service.atualizaUsuario(id, dto);
    }

    public void deletarUsuario(Integer id) {
        service.deletaUsuario(id);
    }
}
