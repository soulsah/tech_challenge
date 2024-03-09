package br.com.fiap.postech.soat.techchallenger1.application.service;

import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CartaoDto;

import java.util.List;

public interface CartaoService {

    List<CartaoDto> getAllCards();
    CartaoDto getCardById(Long id) throws CardNotFoundException;

    CartaoDto createCard(CartaoDto cardDTO);
    void deleteCard(Long id);
}
