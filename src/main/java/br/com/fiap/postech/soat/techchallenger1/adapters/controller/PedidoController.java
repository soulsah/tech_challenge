package br.com.fiap.postech.soat.techchallenger1.adapters.controller;
import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import br.com.fiap.postech.soat.techchallenger1.application.PedidoService;
import br.com.fiap.postech.soat.techchallenger1.domain.exception.CadastroClienteException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
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
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/pedidos/{Cliente_ID}")
    public ResponseEntity<List<PedidoDto>> findPedidoByCliente(@PathVariable("Cliente_ID") Long cliente_id) {
        List<Pedido> pedidos = pedidoService.findPedidoByCliente(cliente_id);
        List<PedidoDto> pedidoDtos = pedidos.stream().map(PedidoDto::new).toList();
        return ResponseEntity.ok().body(pedidoDtos);
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoDto>> findAll(){
        List<Pedido> list = pedidoService.findAll();
        List<PedidoDto> listDto = list.stream().map(PedidoDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }
}
