package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;

import br.com.fiap.postech.soat.techchallenger1.application.exception.TipoProdutoNaoCadastradoException;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ProdutoDto;
import br.com.fiap.postech.soat.techchallenger1.application.service.ProdutoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @Operation(summary = "Busca todos os produtos",
            description = "Busca todos os produtos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<List<ProdutoDto>> findAll(){
        List<Produto> produtos = produtoService.findAll();
        List<ProdutoDto> produtoDtos = produtos.stream().map(ProdutoDto::new).toList();
        return ResponseEntity.ok().body(produtoDtos);
    }

    @Operation(summary = "Busca produto por id",
            description = "Busca produto por id do produto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> findProdutoById(@PathVariable("id") Long produto_id){

        Produto produto = produtoService.findProdutoById(produto_id);
        ProdutoDto produtoDto = new ProdutoDto(produto);
        return ResponseEntity.ok().body(produtoDto);
    }

    @Operation(summary = "Busca produto por tipo",
            description = "Busca produto por tipo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
    })
    @GetMapping("/tipo/{id}")
    public ResponseEntity<List<ProdutoDto>> findProdutosByTipo(@PathVariable("id") Long tipo){
        List<Produto> produtos = produtoService.findProdutosByTipo(tipo);
        List<ProdutoDto> produtoDtos = produtos.stream().map(ProdutoDto::new).toList();
        return ResponseEntity.ok().body(produtoDtos);
    }

    @Operation(summary = "Cadastra novo produto",
            description = "Cadastra novo produto")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Busca realizada com sucesso"),
    })
    @PostMapping
    public ResponseEntity<?> cadastroProduto(@RequestBody ProdutoDto produto) throws TipoProdutoNaoCadastradoException {
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado com sucesso!");
    }


    @Operation(summary = "Atualiza  produto com base no id",
            description = "Atualiza  produto com base no id")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Busca realizada com sucesso"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDto produto){
        Produto produtoExistente = produtoService.findProdutoById(id);

        if(produtoExistente == null){
            return ResponseEntity.notFound().build();
        }

        produtoExistente.setTipo(produto.getTipo());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setPreco(produto.getPreco());

        return ResponseEntity.ok(produtoExistente);
    }

    @Operation(summary = "exclui  produto com base no id",
            description = "exclui  produto com base no id")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Busca realizada com sucesso"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id){
        Produto produtoExistente = produtoService.findProdutoById(id);

        if(produtoExistente == null){
            return ResponseEntity.notFound().build();
        }

        produtoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto "+ produtoExistente.getDescricao() + " excluído com sucesso!");
    }
}
