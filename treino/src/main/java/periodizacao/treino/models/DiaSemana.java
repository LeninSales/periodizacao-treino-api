package periodizacao.treino.models;

import java.util.stream.Stream;

public enum DiaSemana {

        DOMINGO(1),
        SEGUNDA_FEIRA(2),
        TERCA_FEIRA(3),
        QUARTA_FEIRA(4),
        QUINTA_FEIRA(5),
        SEXTA_FEIRA(6),
        SABADO(7);

        private final int valor;

        DiaSemana(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }


        public static DiaSemana fromValor(int valor) {
            return Stream.of(DiaSemana.values())
                    .filter(dia -> dia.getValor() == valor)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Valor de dia da semana inválido: " + valor));
        }

}
