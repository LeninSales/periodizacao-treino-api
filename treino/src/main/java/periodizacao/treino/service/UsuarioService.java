package periodizacao.treino.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import periodizacao.treino.dto.UsuarioDto;
import periodizacao.treino.models.UsuarioModel;
import periodizacao.treino.repository.UsuarioRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository repository;


    public UsuarioModel salvaUsuario(UsuarioDto dto) {
        UsuarioModel user = new UsuarioModel();
        BeanUtils.copyProperties(dto, user);
        return repository.save(user);
    }

    public List<UsuarioModel> listaUsuarios() {
        return repository.findAll();
    }

    public UsuarioModel pegaUmUsuarioPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado."));
    }

    public UsuarioModel atualizaUsuario(Integer id, UsuarioDto dto) {
        UsuarioModel user = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado."));
        user.setNome(dto.nome());

        return repository.save(user);
    }


    public void deletaUsuario(Integer id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Usuário não encontrado para exclusão.");
        }
        repository.deleteById(id);
    }

}
