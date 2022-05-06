package gft.com.desafiotddbanco.model;

import gft.com.desafiotddbanco.tipo.TipoDeNota;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Cedula {

    private Integer quantidadeDeNotasDisponiveis;
    private TipoDeNota nota;

    public Cedula(Integer quantidadeDeNotasDisponiveis, TipoDeNota nota) {
        this.quantidadeDeNotasDisponiveis = quantidadeDeNotasDisponiveis;
        this.nota = nota;

    }


    public void estoqueDeCedulas(Integer quantidade)  {

        if(quantidadeDeNotasDisponiveis < quantidade){

        }

        quantidadeDeNotasDisponiveis = quantidadeDeNotasDisponiveis - quantidade;

    }

}
