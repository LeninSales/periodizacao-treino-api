package periodizacao.treino.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import periodizacao.treino.models.DiaSemana;

@Converter(autoApply = true)
public class DiaSemanaConverter implements AttributeConverter<DiaSemana, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DiaSemana diaSemana) {
        if (diaSemana == null) {
            return null;
        }
        return diaSemana.getValor();
    }

    @Override
    public DiaSemana convertToEntityAttribute(Integer valor) {
        if (valor == null) {
            return null;
        }
        return DiaSemana.fromValor(valor);
    }
}
