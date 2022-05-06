package gft.com.desadiotddbanco.services;

import gft.com.desafiotddbanco.model.Cedula;
import gft.com.desafiotddbanco.repository.CedulasRepository;
import gft.com.desafiotddbanco.services.CedulasService;
import gft.com.desafiotddbanco.tipo.TipoDeNota;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        when(cedulasRepository.
                buscarNotas()).
                thenReturn(cedulasDisponiveisList());

        cedulasService = new CedulasService(cedulasRepository);
    }

    private List<Cedula> cedulasDisponiveisList() {

        List<Cedula> notasDisponiveis = new ArrayList<>();
        notasDisponiveis.add(new Cedula(15, TipoDeNota.NOTAS_100));
        notasDisponiveis.add(new Cedula(10, TipoDeNota.NOTAS_50));
        notasDisponiveis.add(new Cedula(15, TipoDeNota.NOTAS_20));
        notasDisponiveis.add(new Cedula(9, TipoDeNota.NOTAS_10));
        notasDisponiveis.add(new Cedula(0, TipoDeNota.NOTAS_05));
        return notasDisponiveis;

    }

    @Test
    public void retornarCedulasDisponiveisComSucesso() {

        List<Cedula> retornar = cedulasService.estoqueDeNotas();
        assertEquals(cedulasDisponiveisList(), retornar);

    }

    @Test
    public void retonarCedulasDeVinteSacadasComSucesso() {

        Optional<Cedula> retorna = cedulasService.tipoDeCedula(TipoDeNota.NOTAS_20);

        assertEquals(Optional.of(15), Optional.ofNullable(retorna.get().getQuantidadeDeNotasDisponiveis()));

    }

    @Test
    public void retornarCedulasDeCinquentaComSucesso() {

        Optional<Cedula> retorna = cedulasService.tipoDeCedula(TipoDeNota.NOTAS_50);

        assertEquals(Optional.of(10), Optional.ofNullable(retorna.get().getQuantidadeDeNotasDisponiveis()));

    }

    @Test
    public void retornarCedulasDeCemComSucesso() {

        Optional<Cedula> retorna = cedulasService.tipoDeCedula(TipoDeNota.NOTAS_100);

        assertEquals(Optional.of(15), Optional.ofNullable(retorna.get().getQuantidadeDeNotasDisponiveis()));

    }

    @Test
    public void retornarCedulasDeDezComSucesso() {

        Optional<Cedula> retorna = cedulasService.tipoDeCedula(TipoDeNota.NOTAS_10);

        assertEquals(Optional.of(9), Optional.ofNullable(retorna.get().getQuantidadeDeNotasDisponiveis()));

    }

    @Test
    public void retornarExceptionSeACedulaPedidaNaoEstiverDisponivelNoCaixa() {

        Optional<Cedula> retorna = cedulasService.tipoDeCedula(TipoDeNota.NOTAS_05);

        assertEquals(Optional.of(0), Optional.ofNullable(retorna.get().getQuantidadeDeNotasDisponiveis()));

    }

}






