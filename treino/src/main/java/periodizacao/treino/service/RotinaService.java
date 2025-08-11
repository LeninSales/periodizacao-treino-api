package periodizacao.treino.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import periodizacao.treino.dto.RotinaDto;
import periodizacao.treino.dto.UsuarioDto;
import periodizacao.treino.models.DiaSemana;
import periodizacao.treino.models.ExercicioModel;
import periodizacao.treino.models.RotinaModel;
import periodizacao.treino.models.UsuarioModel;
import periodizacao.treino.repository.ExercicioRepository;
import periodizacao.treino.repository.RotinaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RotinaService {
    // salvar, listar por user,  pegar uma rotina por exercicio,atualizar e deletar
    @Autowired
    private RotinaRepository repository;

    public RotinaModel salvarRotina(RotinaDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dados da rotina não informados.");
        }
        RotinaModel rotinaNova = new RotinaModel();

        BeanUtils.copyProperties(dto, rotinaNova);
        return repository.save(rotinaNova);
    }

    public List<RotinaModel> listaPorUsuario(Integer usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public RotinaModel buscarRotinaPorId(Integer rotinaId) {
        return repository.findById(rotinaId).orElseThrow(() -> new NoSuchElementException("Rotina não encontrada."));

    }

    public RotinaModel atualizaRotina(RotinaDto dto, Integer rotinaId) {
        RotinaModel rotinaExistente = repository.findById(rotinaId).orElseThrow(() -> new NoSuchElementException("Rotina não encontrada."));

        rotinaExistente.setNome(dto.nome());
        rotinaExistente.setDiaSemana(dto.diaSemana());

        return repository.save(rotinaExistente);
    }

    public void excluirRotina(Integer rotinaId) {
        if (!repository.existsById(rotinaId)) {
            throw new NoSuchElementException("Rotina não encontrada.");
        }
        repository.deleteById(rotinaId);
    }

}

