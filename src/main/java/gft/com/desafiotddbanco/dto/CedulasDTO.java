package gft.com.desafiotddbanco.dto;

import gft.com.desafiotddbanco.tipo.TipoDeNota;
import lombok.Data;

@Data
public class CedulasDTO {

    private TipoDeNota tipoDeNota;
    private Integer quantidade;

}
