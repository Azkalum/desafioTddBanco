package gft.com.desafiotddbanco.controller;

import gft.com.desafiotddbanco.services.SaqueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saque")
@Api("API Caixa Eletrônico - Desafio TDD GFT")
public class SaqueController {

    private final SaqueService saqueService;

    public SaqueController(SaqueService saqueService){
        this.saqueService = saqueService;

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{valor}")
    @ApiOperation("Sacar um valor do Caixa Eletrônico")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Saque feito com sucesso!"),
            @ApiResponse(code = 500, message = "O Saque não foi concluído com sucesso! Favor conferir e tentar novamente")
    })
    public ResponseEntity<?> retornoValorDoSaque(@PathVariable("valor") Integer valor) {

        return new ResponseEntity<>(saqueService.sacarCedulas(valor), HttpStatus.OK);

    }

}
