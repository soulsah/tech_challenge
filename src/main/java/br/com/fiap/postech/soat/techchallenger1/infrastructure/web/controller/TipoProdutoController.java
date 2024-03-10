package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;

import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.exception.TipoProdutoNaoCadastradoException;
import br.com.fiap.postech.soat.techchallenger1.application.service.TipoProdutoService;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CartaoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.TipoProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_pedido")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoService tipoProdutoService;


    @Operation(summary = "Busca todos os tipos de  produtos ",
            description = "Busca todos os  tipos de  produtos na base de dados ")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<List<TipoProdutoDto>> getAllTipoProduto() {
        return ResponseEntity.ok().body(tipoProdutoService.getAllTipoProduto());
    }

    @Operation(summary = "busca tipo de   produto com base no id",
            description = "busca tipo de  produto com base no id na base de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada incorretos"),
    })

    @GetMapping("/{id}")
    public ResponseEntity<TipoProdutoDto> getTipoProdutoById(@PathVariable Long id) throws CardNotFoundException, TipoProdutoNaoCadastradoException {
        var tipoProduto =  tipoProdutoService.getTipoProdutoById(id);
        return ResponseEntity.ok().body(tipoProduto);
    }

    @Operation(summary = "Cadastra novo tipo de produto",
            description = "Cadastra novo tipo de produto")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cadastro realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada incorretos"),
    })
    @PostMapping
    public ResponseEntity<TipoProdutoDto> createTipoProduto(@RequestBody TipoProdutoDto tipoProdutoDto) {
        TipoProdutoDto tipoProduto = tipoProdutoService.createTipoProduto(tipoProdutoDto);
        return new ResponseEntity<>(tipoProduto, HttpStatus.CREATED);
    }
}
