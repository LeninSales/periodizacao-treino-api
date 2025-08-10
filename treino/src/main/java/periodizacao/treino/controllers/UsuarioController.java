package periodizacao.treino.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import periodizacao.treino.dto.UsuarioDto;
import periodizacao.treino.service.UsuarioService;
import periodizacao.treino.models.UsuarioModel;


import java.util.List;

@Component
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    public UsuarioModel criarUsuario(UsuarioDto dto) {
        return service.salvaUsuario(dto);
    }

    public List<UsuarioModel> listarUsuarios() {
        List<UsuarioModel> usuarios = service.listaUsuarios();
        if(usuarios.isEmpty()){
            throw new IllegalStateException("Nenhum usuário encontrado.");
        }
        return usuarios;
    }

    public UsuarioModel buscarUsuario(Integer id) {
        return service.pegaUmUsuario(id);
    }

    public UsuarioModel atualizarUsuario(Integer id, UsuarioDto dto) {
        return service.atualizaUsuario(id, dto);
    }

    public void deletarUsuario(Integer id) {
        service.deletaUsuario(id);
    }
}
