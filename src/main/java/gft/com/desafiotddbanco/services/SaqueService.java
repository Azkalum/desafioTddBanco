package gft.com.desafiotddbanco.services;

import gft.com.desafiotddbanco.dto.CedulasDTO;
import gft.com.desafiotddbanco.model.Cedula;
import gft.com.desafiotddbanco.tipo.TipoDeNota;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SaqueService {

    private CedulasService cedulasService;

    public SaqueService(CedulasService cedulasT){
        this.cedulasService = cedulasT;

    }

    public List<CedulasDTO> sacarCedulas(int valor) {

        List<CedulasDTO> listDtoCedulas = buscarCedulas(valor);
        atualizarAposBuscaDeCedulas(listDtoCedulas);

        return listDtoCedulas;

    }

    private List<CedulasDTO> buscarCedulas(int valor){

        List<CedulasDTO> cedulasDtoList = new ArrayList<>();

        int resto = valor;

        for(Cedula cedula : cedulasService.estoqueDeNotas()){
            Optional<CedulasDTO> cedulasDTO = quantidadeDeCadaTipoDeNota(cedula.getNota(), resto);

            if(cedulasDTO.isPresent()){
                cedulasDtoList.add(cedulasDTO.get());
                    resto = resto - (cedula.getNota().getValor() * cedulasDTO.get().getQuantidade());

            }
        }

        if(resto >= 10){
            return null;

        }else if(resto != 0){
            return null;
        }

        return cedulasDtoList;

    }


    private void atualizarAposBuscaDeCedulas(List<CedulasDTO> cedulasDTOList) {
        cedulasDTOList.
                stream().
                forEach(cedulasDTO -> {
                    try {
                        cedulasService.retiradaDeCedulas(cedulasDTO.getTipoDeNota(), cedulasDTO.getQuantidade());
                    } catch (Exception e) {

                    }

                });
    }

    private Optional<CedulasDTO> quantidadeDeCadaTipoDeNota(TipoDeNota tipoDeNota, int resto){

        if(resto >= tipoDeNota.getValor()){
            int quantidade = resto / tipoDeNota.getValor();
            Optional<Cedula> cedula = cedulasService.tipoDeCedula(tipoDeNota);

            if(cedula.isPresent()){
                if (quantidade > cedula.get().getQuantidadeDeNotasDisponiveis()){
                    quantidade = cedula.get().getQuantidadeDeNotasDisponiveis();
                }
                else if (quantidade > 0 ){

                    return Optional.of(montarCedulasDTO(quantidade,tipoDeNota));

                }
            }
        }

        return Optional.empty();

    }

    private CedulasDTO montarCedulasDTO(int quantidade, TipoDeNota tipo) {

        CedulasDTO cedulaDTO = new CedulasDTO();
        cedulaDTO.setQuantidade(quantidade);
        cedulaDTO.setTipoDeNota(tipo);
        return cedulaDTO;

    }

}
