package br.com.fiap.postech.soat.techchallenger1.adapters.controller;

import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ProdutoDto;
import br.com.fiap.postech.soat.techchallenger1.application.ProdutoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDto>> findAll(){
        List<Produto> produtos = produtoService.findAll();
        List<ProdutoDto> produtoDtos = produtos.stream().map(ProdutoDto::new).toList();
        return ResponseEntity.ok().body(produtoDtos);
    }

    @GetMapping("/produto/{ID}")
    public ResponseEntity<ProdutoDto> findProdutoById(@PathVariable("ID") Long produto_id){
        /*
         * TODO:
         *  Tratar exceções 404
         */
        Produto produto = produtoService.findProdutoById(produto_id);
        ProdutoDto produtoDto = new ProdutoDto(produto);
        return ResponseEntity.ok().body(produtoDto);
    }
}
