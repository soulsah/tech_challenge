package br.com.fiap.postech.soat.techchallenger1.adapters.controller;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.*;
import br.com.fiap.postech.soat.techchallenger1.application.PedidoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

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
    public ResponseEntity novoPedido(@RequestBody NovoPedidoDto novoPedidoDto){
        pedidoService.novoPedido(novoPedidoDto.getPedido(),novoPedidoDto.getItensPedido());
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido criado!");
    }
}
