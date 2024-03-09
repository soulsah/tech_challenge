package br.com.fiap.postech.soat.techchallenger1.application.service.Impl;

import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.application.repository.CartaoRepository;
import br.com.fiap.postech.soat.techchallenger1.application.service.CartaoService;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CartaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoServiceImpl implements CartaoService {

        @Autowired
        private CartaoRepository cardRepository;

        public List<CartaoDto> getAllCards() {
            return cardRepository.findAll();
        }

        public CartaoDto getCardById(Long id) throws CardNotFoundException {
            CartaoDto card =  cardRepository.findById(id);

            return card;
        }

        public CartaoDto createCard(CartaoDto cardDTO) {
            return cardRepository.save(cardDTO);
        }

        public void deleteCard(Long id) {
            cardRepository.deleteById(id);
        }
}
