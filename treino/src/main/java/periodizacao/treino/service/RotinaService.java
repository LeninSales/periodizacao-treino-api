package periodizacao.treino.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import periodizacao.treino.dto.RotinaDto;
import periodizacao.treino.models.DiaSemana;
import periodizacao.treino.models.RotinaModel;
import periodizacao.treino.repository.RotinaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RotinaService {

    @Autowired
    private RotinaRepository repository;


    public Optional<RotinaModel> buscarRotinaPorId(Integer id) {
        return repository.findById(id);
    }

    public List<RotinaModel> buscarRotinasPorUsuarioEDia(Integer usuarioId, DiaSemana diaSemana) {
        return repository.findByUsuarioIdAndDiaSemana(usuarioId, diaSemana);
    }

    public RotinaModel atualizarRotina(Integer id, RotinaDto dto) {
        RotinaModel rotinaExistente = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rotina não encontrada com o ID: " + id));

        BeanUtils.copyProperties(dto, rotinaExistente, "id");

        return repository.save(rotinaExistente);
    }

    public void deletarRotina(Integer id) {
        repository.deleteById(id);
    }
}
