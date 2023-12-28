package br.com.fiap.postech.soat.techchallenger1.adapters.controller;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ItemPedidoDto;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ProdutoDto;
import br.com.fiap.postech.soat.techchallenger1.application.ItemPedidoService;
import br.com.fiap.postech.soat.techchallenger1.application.PedidoService;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.PedidoDto;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> findAll(){
        List<Pedido> list = pedidoService.findAll();
        List<PedidoDto> listDto = list.stream().map(PedidoDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/cliente/{cliente_id}")
    public ResponseEntity<List<PedidoDto>> findPedidosByClienteId(@PathVariable("cliente_id") Long cliente_id) {
        List<Pedido> pedidos = pedidoService.findPedidosByClienteId(cliente_id);
        List<PedidoDto> pedidoDtos = pedidos.stream().map(PedidoDto::new).toList();
        return ResponseEntity.ok().body(pedidoDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> findPedidoById(@PathVariable Long id){
        Pedido pedido = pedidoService.findPedidoById(id);
        return ResponseEntity.ok().body(new PedidoDto(pedido));
    }

    @PostMapping("/novo")
    public ResponseEntity novoPedido(@RequestBody PedidoDto pedido){
        pedidoService.novoPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido criado!");
    }

    @PostMapping("/add/{id}")
    public ResponseEntity addItem(@PathVariable Long id, @RequestBody ItemPedidoDto item){
        Pedido pedido = pedidoService.findPedidoById(id);
        if(pedido != null){
            item.setPedidoId(id);
            itemPedidoService.save(item);
            return ResponseEntity.status(HttpStatus.OK).body("Item adicionado ao pedido com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
    }
}
