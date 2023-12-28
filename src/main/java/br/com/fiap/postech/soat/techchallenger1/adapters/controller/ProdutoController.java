package br.com.fiap.postech.soat.techchallenger1.adapters.controller;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ProdutoDto;
import br.com.fiap.postech.soat.techchallenger1.application.ProdutoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
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

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> findAll(){
        List<Produto> produtos = produtoService.findAll();
        List<ProdutoDto> produtoDtos = produtos.stream().map(ProdutoDto::new).toList();
        return ResponseEntity.ok().body(produtoDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> findProdutoById(@PathVariable("id") Long produto_id){
        /*
         * TODO:
         *  Tratar exceções 404
         */
        Produto produto = produtoService.findProdutoById(produto_id);
        ProdutoDto produtoDto = new ProdutoDto(produto);
        return ResponseEntity.ok().body(produtoDto);
    }

    @GetMapping("/tipo/{id}")
    public ResponseEntity<List<ProdutoDto>> findProdutosByTipo(@PathVariable("id") Long tipo){
        List<Produto> produtos = produtoService.findProdutosByTipo(tipo);
        List<ProdutoDto> produtoDtos = produtos.stream().map(ProdutoDto::new).toList();
        return ResponseEntity.ok().body(produtoDtos);
    }

    @PostMapping
    public ResponseEntity cadastroProduto(@RequestBody ProdutoDto produto){
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDto produto){
        Produto produtoExistente = produtoService.findProdutoById(id);

        if(produtoExistente == null){
            return ResponseEntity.notFound().build();
        }

        produtoExistente.setTipo(produto.getTipo());
        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setPreco(produto.getPreco());

        return ResponseEntity.ok(produtoExistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirProduto(@PathVariable Long id){
        Produto produtoExistente = produtoService.findProdutoById(id);

        if(produtoExistente == null){
            return ResponseEntity.notFound().build();
        }

        produtoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto "+ produtoExistente.getDescricao() + " excluído com sucesso!");
    }
}
