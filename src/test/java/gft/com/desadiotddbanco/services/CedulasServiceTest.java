package gft.com.desadiotddbanco.services;

import gft.com.desafiotddbanco.model.Cedula;
import gft.com.desafiotddbanco.repository.CedulasRepository;
import gft.com.desafiotddbanco.services.CedulasService;
import gft.com.desafiotddbanco.tipo.TipoDeNota;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CedulasServiceTest {

    @Autowired
    CedulasService cedulasService;

    @Autowired
    CedulasRepository cedulasRepository;

    @Before
    public void setup() {
        cedulasRepository = mock(CedulasRepository.class);
        when(cedulasRepository.buscarNotas()).
                thenReturn(cedulasDisponiveisList());
    }

    private List<Cedula> cedulasDisponiveisList() {

        List<Cedula> notasDisponiveis = new ArrayList<>();
        notasDisponiveis.add(new Cedula(15, TipoDeNota.NOTAS_100));
        notasDisponiveis.add(new Cedula(10, TipoDeNota.NOTAS_50));
        notasDisponiveis.add(new Cedula(15, TipoDeNota.NOTAS_20));

        return notasDisponiveis;

    }

    @Test
    public void retornarCedulasDeVinte(){

        Optional<Cedula> cedulaOptional = cedulasService.tipoDeCedula(TipoDeNota.NOTAS_20);
        Assert.assertEquals(Optional.of(15),
                Optional.ofNullable(cedulaOptional.
                        get().
                           getQuantidadeDeNotasDisponiveis()));

    }

    @Test
    public void deveRetornarCedulaVaziaQuandoNaoEncontrar() {

        Optional<Cedula> cedulaOptional = cedulasService.tipoDeCedula(TipoDeNota.NOTAS_10);

        assertFalse(cedulaOptional.isPresent());

    }

}
