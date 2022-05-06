package gft.com.desafiotddbanco.controller;

import gft.com.desafiotddbanco.services.SaqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas/saques")
public class SaqueController {

    private final SaqueService saqueService;

    public SaqueController(SaqueService saqueService){
        this.saqueService = saqueService;

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{valor}")
    public ResponseEntity<?> retornoValorDoSaque(@PathVariable("valor") Integer valor) {

        return new ResponseEntity<>(saqueService.sacarCedulas(valor), HttpStatus.OK);

    }

}
