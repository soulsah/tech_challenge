package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.NovoPedidoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoDto;
import br.com.fiap.postech.soat.techchallenger1.application.service.FilaService;
import br.com.fiap.postech.soat.techchallenger1.application.service.PedidoService;
<<<<<<< HEAD
import br.com.fiap.postech.soat.techchallenger1.application.exception.PedidoException;
=======
import br.com.fiap.postech.soat.techchallenger1.domain.exception.PedidoException;
>>>>>>> e77518c0e3dfbb4069ea381664d56ab75376a827
import br.com.fiap.postech.soat.techchallenger1.domain.model.FilaPedido;
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
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    FilaService filaService;


    @Operation(summary = "Busca todos os pedidos",
            description = "Busca todos os pedidos na base de datos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedidos encontrados"),
            @ApiResponse(responseCode = "400", description = "Nenhum pedido encontrado")
    })
    @GetMapping
    public ResponseEntity<List<PedidoDto>> findAll() throws PedidoException{
        return ResponseEntity.ok().body(pedidoService.findAll().stream().map(PedidoDto::new).toList());
    }

    @Operation(summary = "Busca pedidos de cliente",
            description = "Busca pedidos de cliente específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedidos encontrados"),
            @ApiResponse(responseCode = "400", description = "Pedidos não encontrados")
    })
    @GetMapping("/cliente/{cliente_id}")
    public ResponseEntity<List<PedidoDto>> findPedidosByClienteId(@PathVariable("cliente_id") Long cliente_id) throws PedidoException{
        return ResponseEntity.ok().body(pedidoService.findPedidosByClienteId(cliente_id).stream().map(PedidoDto::new).toList());
    }

    @Operation(summary = "Busca pedido",
            description = "Busca pedido específico por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
            @ApiResponse(responseCode = "400", description = "Pedido não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> findPedidoById(@PathVariable Long id) throws PedidoException {
        return ResponseEntity.ok().body(new PedidoDto(pedidoService.findPedidoById(id)));
    }

    @PostMapping("/novo")
    public ResponseEntity<?> novoPedido(@RequestBody NovoPedidoDto novoPedidoDto){
        pedidoService.novoPedido(novoPedidoDto.getPedido(),novoPedidoDto.getItensPedido());
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido criado!");
    }

    @GetMapping("/iniciar/{id}")
    public ResponseEntity<?> iniciarPedido(@PathVariable Long id){
        FilaPedido filaPedido = filaService.findFilaPedidoByPedidoId(id);
        if(filaPedido != null){
            if(filaPedido.getStatusPedido().ordinal() != 0){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Não foi possível iniciar o pedido!\n" +
                        "Status do pedido: " + filaPedido.getStatusPedido());
            }
            filaService.processarPedido(filaPedido);
            return ResponseEntity.status(HttpStatus.OK).body("Novo status: " + filaPedido.getStatusPedido());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
    }

    @GetMapping("/finalizar/{id}")
    public ResponseEntity<?> finalizarPedido(@PathVariable Long id){
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
    public ResponseEntity<?> entregarPedido(@PathVariable Long id){
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
