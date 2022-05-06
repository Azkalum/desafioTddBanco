package gft.com.desafiotddbanco.services;


import gft.com.desafiotddbanco.model.Cedula;
import gft.com.desafiotddbanco.repository.CedulasRepository;
import gft.com.desafiotddbanco.tipo.TipoDeNota;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CedulasService {

    private List<Cedula> notaDisponivel;
    private final CedulasRepository cedulasRepository;

    public CedulasService(CedulasRepository cedulasRepository) {
        this.cedulasRepository = cedulasRepository;
    }

    private void notasDisponiveis(){

        notaDisponivel = cedulasRepository.buscarNotas();

    }

    public Optional<Cedula> tipoDeCedula(TipoDeNota tipoDeNota){

        if(notaDisponivel == null || notaDisponivel.isEmpty()){
            notasDisponiveis();

        }
        return notaDisponivel.stream().
                filter(cedula -> cedula.getNota().
                        equals(tipoDeNota)).findFirst();

    }

    public List<Cedula> estoqueDeNotas(){

        if(notaDisponivel == null || notaDisponivel.isEmpty()){
            notasDisponiveis();

        }
        return notaDisponivel.stream().
                filter(cedula -> cedula.
                        getQuantidadeDeNotasDisponiveis() > 0).
                              collect(Collectors.toList());

    }

    public void retiradaDeCedulas(TipoDeNota tipoDeNota, int quantidade) {

        Optional<Cedula> cedulaOptional = tipoDeCedula(tipoDeNota);

        if(cedulaOptional.isPresent()){
            cedulaOptional.get().
                    estoqueDeCedulas(quantidade);

        }


    }

}
