package br.com.fiap.postech.soat.techchallenger1.application.service;

import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CartaoDto;

import java.util.List;

public interface CartaoService {

    public List<CartaoDto> getAllCards();
    public CartaoDto getCardById(Long id) throws CardNotFoundException;

    public CartaoDto createCard(CartaoDto cardDTO);
    public void deleteCard(Long id);
}
