package br.com.fiap.postech.soat.techchallenger1.adapters.controller;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.*;
import br.com.fiap.postech.soat.techchallenger1.application.FilaService;
import br.com.fiap.postech.soat.techchallenger1.application.PedidoService;
import br.com.fiap.postech.soat.techchallenger1.domain.model.FilaPedido;
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

    @Autowired
    FilaService filaService;

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
    public ResponseEntity findPedidoById(@PathVariable Long id){
        Pedido pedido = pedidoService.findPedidoById(id);
        if(pedido != null){
            return ResponseEntity.ok().body(new PedidoDto(pedido));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
    }

    @PostMapping("/novo")
    public ResponseEntity novoPedido(@RequestBody NovoPedidoDto novoPedidoDto){
        pedidoService.novoPedido(novoPedidoDto.getPedido(),novoPedidoDto.getItensPedido());
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido criado!");
    }

    @GetMapping("/iniciar/{id}")
    public ResponseEntity iniciarPedido(@PathVariable Long id){
        FilaPedido filaPedido = filaService.findFilaPedidoByPedidoId(id);
        if(filaPedido != null){
            filaService.processarPedido(filaPedido);
            return ResponseEntity.status(HttpStatus.OK).body("Novo status: " + filaPedido.getStatusPedido());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
    }

    @GetMapping("/finalizar/{id}")
    public ResponseEntity finalizarPedido(@PathVariable Long id){
        FilaPedido filaPedido = filaService.findFilaPedidoByPedidoId(id);
        if(filaPedido != null){
            if(filaPedido.getStatusPedido().ordinal() != 1){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Não foi possível atualizar pedido!\n" +
                        "Status do pedido: " + filaPedido.getStatusPedido());
            }
            filaService.processarPedido(filaPedido);
            return ResponseEntity.status(HttpStatus.OK).body("Novo status: " + filaPedido.getStatusPedido());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
    }

    @GetMapping("/entregar/{id}")
    public ResponseEntity entregarPedido(@PathVariable Long id){
        FilaPedido filaPedido = filaService.findFilaPedidoByPedidoId(id);
        if(filaPedido != null){
            if(filaPedido.getStatusPedido().ordinal() != 2){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Não foi possível entregar o pedido!\n" +
                        "Status do pedido: " + filaPedido.getStatusPedido());
            }
            filaService.processarPedido(filaPedido);
            return ResponseEntity.status(HttpStatus.OK).body("Novo status: " + filaPedido.getStatusPedido());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
    }
}
