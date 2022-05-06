package gft.com.desadiotddbanco.services;

import gft.com.desafiotddbanco.dto.CedulasDTO;
import gft.com.desafiotddbanco.model.Cedula;
import gft.com.desafiotddbanco.services.CedulasService;
import gft.com.desafiotddbanco.services.SaqueService;
import gft.com.desafiotddbanco.tipo.TipoDeNota;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaqueServiceTest {

    @Autowired
    SaqueService saqueService;

    @Autowired
    CedulasService cedulasService;

    @Before
    public void setup() {
        cedulasService = mock(CedulasService.class);
        saqueService = new SaqueService(cedulasService);

    }

    private void mockDasCedulas(TipoDeNota tipoNota, int quantidade) {
        when(cedulasService.tipoDeCedula(tipoNota))
                .thenReturn(java.util.Optional.of(new Cedula(quantidade, tipoNota)));
    }

    private CedulasDTO retornoDeNotas(int quantidade, TipoDeNota tipo) {
        CedulasDTO cedulaDTO = new CedulasDTO();
        cedulaDTO.setQuantidade(quantidade);
        cedulaDTO.setTipoDeNota(tipo);
        return cedulaDTO;

    }

    private List<Cedula> cedulasDisponiveisList() {
        List<Cedula> notasDisponiveis = new ArrayList<>();
        notasDisponiveis.add(new Cedula(15, TipoDeNota.NOTAS_100));
        notasDisponiveis.add(new Cedula(10, TipoDeNota.NOTAS_50));
        notasDisponiveis.add(new Cedula(15, TipoDeNota.NOTAS_20));
        notasDisponiveis.add(new Cedula(9, TipoDeNota.NOTAS_10));
        return notasDisponiveis;

    }

    @Test
    public void retornarUmSaqueDe340ComSucesso() {

        List<CedulasDTO> cedulasDTO = new ArrayList<>();
        cedulasDTO.add(retornoDeNotas(3, TipoDeNota.NOTAS_100));
        cedulasDTO.add(retornoDeNotas(2, TipoDeNota.NOTAS_20));
        when(cedulasService.estoqueDeNotas()).thenReturn(cedulasDisponiveisList());

        mockDasCedulas(TipoDeNota.NOTAS_100, 3);
        mockDasCedulas(TipoDeNota.NOTAS_20, 2);

        try {
            List<CedulasDTO> cedulas = saqueService.sacarCedulas(340);
            assertArrayEquals(cedulasDTO.toArray(), cedulas.toArray());
        } catch (Exception e) {
            fail("Erro! Favor conferir e tentar novamente! ");
        }

    }

    @Test
    public void retornarUmSaqueDe190ComSucesso() {

        List<CedulasDTO> cedulasDTO = new ArrayList<>();
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_100));
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_50));
        cedulasDTO.add(retornoDeNotas(2, TipoDeNota.NOTAS_20));
        when(cedulasService.estoqueDeNotas()).thenReturn(cedulasDisponiveisList());

        mockDasCedulas(TipoDeNota.NOTAS_100, 1);
        mockDasCedulas(TipoDeNota.NOTAS_50, 1);
        mockDasCedulas(TipoDeNota.NOTAS_20, 2);

        try {
            List<CedulasDTO> cedulas = saqueService.sacarCedulas(190);
            assertArrayEquals(cedulasDTO.toArray(), cedulas.toArray());
        } catch (Exception e) {
            fail("Erro! Favor conferir e tentar novamente! ");
        }

    }

    @Test
    public void retornarUmSaqueDe30ComSucesso() {

        List<CedulasDTO> cedulasDTO = new ArrayList<>();
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_20));
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_10));
        when(cedulasService.estoqueDeNotas()).thenReturn(cedulasDisponiveisList());

        mockDasCedulas(TipoDeNota.NOTAS_20, 1);
        mockDasCedulas(TipoDeNota.NOTAS_10, 1);

        try {
            List<CedulasDTO> cedulas = saqueService.sacarCedulas(30);
            assertArrayEquals(cedulasDTO.toArray(), cedulas.toArray());
        } catch (Exception e) {
            fail("Erro! Favor conferir e tentar novamente! ");
        }

    }

    @Test
    public void retornarUmSaqueDe180ComSucesso() {

        List<CedulasDTO> cedulasDTO = new ArrayList<>();
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_100));
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_50));
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_20));
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_10));
        when(cedulasService.estoqueDeNotas()).thenReturn(cedulasDisponiveisList());

        mockDasCedulas(TipoDeNota.NOTAS_100, 1);
        mockDasCedulas(TipoDeNota.NOTAS_50, 1);
        mockDasCedulas(TipoDeNota.NOTAS_20, 1);
        mockDasCedulas(TipoDeNota.NOTAS_10, 1);

        try {
            List<CedulasDTO> cedulas = saqueService.sacarCedulas(180);
            assertArrayEquals(cedulasDTO.toArray(), cedulas.toArray());
        } catch (Exception e) {
            fail("Erro! Favor conferir e tentar novamente! ");
        }
    }

    @Test
    public void retornarUmSaqueDe110ComSucesso() {

        List<CedulasDTO> cedulasDTO = new ArrayList<>();
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_100));
        cedulasDTO.add(retornoDeNotas(1, TipoDeNota.NOTAS_10));
        when(cedulasService.estoqueDeNotas()).thenReturn(cedulasDisponiveisList());

        mockDasCedulas(TipoDeNota.NOTAS_100, 1);
        mockDasCedulas(TipoDeNota.NOTAS_10, 1);

        try {
            List<CedulasDTO> cedulas = saqueService.sacarCedulas(110);
            assertArrayEquals(cedulasDTO.toArray(), cedulas.toArray());
        } catch (Exception e) {
            fail("Erro! Favor conferir e tentar novamente! ");
        }
    }

}

