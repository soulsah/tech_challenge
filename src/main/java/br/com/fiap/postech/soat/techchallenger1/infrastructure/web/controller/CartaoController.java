package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;

import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.service.CartaoService;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CartaoDto;
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

        @GetMapping
        public ResponseEntity<List<CartaoDto>> getAllCards() {
            return ResponseEntity.ok().body(cardService.getAllCards());
        }

        @GetMapping("/{id}")
        public ResponseEntity<CartaoDto> getCardById(@PathVariable Long id) throws CardNotFoundException {
           var cartao =  cardService.getCardById(id);
            return ResponseEntity.ok().body(cartao);
        }

        @PostMapping
        public ResponseEntity<CartaoDto> createCard(@RequestBody CartaoDto cardDTO) {
            CartaoDto createdCard = cardService.createCard(cardDTO);
            return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
            cardService.deleteCard(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

}
