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

    public RotinaModel salvarRotina(RotinaDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dados da rotina não informados.");
        }
        RotinaModel rotinaNova = new RotinaModel();

        BeanUtils.copyProperties(dto, rotinaNova);
        return repository.save(rotinaNova);
    }

    public RotinaModel buscarRotinaPorId(Integer rotinaId) {
        return repository.findById(rotinaId).orElseThrow(() -> new NoSuchElementException("Rotina não encontrada."));
    }

    public RotinaModel atualizaRotina(RotinaDto dto, Integer rotinaId) {
        RotinaModel rotinaExistente = repository.findById(rotinaId)
                .orElseThrow(() -> new NoSuchElementException("Rotina não encontrada com o ID: " + rotinaId));

        rotinaExistente.setNome(dto.nome());
        rotinaExistente.setDiaSemana(dto.diaSemana());
        return repository.save(rotinaExistente);
    }

    public void deletaRotina(Integer rotinaId) {
        if (!repository.existsById(rotinaId)) {
            throw new NoSuchElementException("Rotina não encontrada.");
        }
        repository.deleteById(rotinaId);
    }
}
