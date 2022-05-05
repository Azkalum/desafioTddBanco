package gft.com.desafiotddbanco.repository;

import gft.com.desafiotddbanco.model.Cedula;
import gft.com.desafiotddbanco.tipo.TipoDeNota;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CedulasRepository {

    private List<Cedula> quantidadeDeNotasDisponiveis;

    public CedulasRepository(){

        quantidadeDeNotasDisponiveis = new ArrayList<>();
        quantidadeDeNotasDisponiveis.add(new Cedula(15, TipoDeNota.NOTAS_100));
        quantidadeDeNotasDisponiveis.add(new Cedula(10, TipoDeNota.NOTAS_50));
        quantidadeDeNotasDisponiveis.add(new Cedula(15, TipoDeNota.NOTAS_20));
        quantidadeDeNotasDisponiveis.add(new Cedula(9, TipoDeNota.NOTAS_10));
    }

    public List<Cedula> buscarNotas(){
        return quantidadeDeNotasDisponiveis;
    }

}
