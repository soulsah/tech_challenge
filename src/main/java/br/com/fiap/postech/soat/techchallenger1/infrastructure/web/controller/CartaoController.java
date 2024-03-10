package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;

import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.service.CartaoService;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CartaoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

        @Autowired
        private CartaoService cardService;

    @Operation(summary = "Busca todos os cartões",
            description = "Busca todos os cartões na base de datos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cartões encontrados"),
            @ApiResponse(responseCode = "400", description = "Nenhum cartão encontrado")
    })
        @GetMapping
        public ResponseEntity<List<CartaoDto>> getAllCards() {
            return ResponseEntity.ok().body(cardService.getAllCards());
        }

    @Operation(summary = "Busca  cartão por id",
            description = "Busca  cartão por id na base de datos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cartão encontrado"),
            @ApiResponse(responseCode = "400", description = "Nenhum cartão encontrado")
    })
        @GetMapping("/{id}")
        public ResponseEntity<CartaoDto> getCardById(@PathVariable Long id) throws CardNotFoundException {
           var cartao =  cardService.getCardById(id);
            return ResponseEntity.ok().body(cartao);
        }

    @Operation(summary = "Salvar um cartão",
            description = "Salvar um cartão na base de datos")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cartão cadastrado"),
            @ApiResponse(responseCode = "400", description = "informação de entrada incorreta")
    })
        @PostMapping
        public ResponseEntity<CartaoDto> createCard(@RequestBody CartaoDto cardDTO) {
            CartaoDto createdCard = cardService.createCard(cardDTO);
            return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
        }

    @Operation(summary = "deletar um cartão",
            description = "deletar cartão na base de datos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cartão deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Nenhum cartão encontrado")
    })

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
            cardService.deleteCard(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

}
