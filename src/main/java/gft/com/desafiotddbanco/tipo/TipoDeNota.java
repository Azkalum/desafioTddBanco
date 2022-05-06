package gft.com.desafiotddbanco.tipo;

import lombok.Getter;

@Getter
public enum TipoDeNota {

    NOTAS_10(10),
    NOTAS_20(20),
    NOTAS_50(50),
    NOTAS_100(100),
    NOTAS_05(0);

    private Integer valor;

    TipoDeNota(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor(){
        return valor;

    }
}
