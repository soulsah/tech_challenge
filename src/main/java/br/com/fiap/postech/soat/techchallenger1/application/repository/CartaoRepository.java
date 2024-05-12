package br.com.fiap.postech.soat.techchallenger1.application.repository;

import br.com.fiap.postech.soat.techchallenger1.application.exception.CardNotFoundException;
import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.persistence.CartaoRepositoryDB;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CartaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CartaoRepository {
    @Autowired
    CartaoRepositoryDB cartaoRepositoryDB;


    public List<CartaoDto> findAll() {
        var listaCartoes = cartaoRepositoryDB.findAll();
        return listaCartoes.stream().map(CartaoDto::new).collect(Collectors.toList());
    }

    public CartaoDto findById(Long id) throws CardNotFoundException {
        var cartao = cartaoRepositoryDB.findById(id);
        if (cartao == null) {
            throw new CardNotFoundException("Card not found");
        }

        return new CartaoDto(cartao);
    }

    public CartaoDto save(CartaoDto cardDTO) {
        Cartao cartao = new Cartao(cardDTO);
        return new CartaoDto(cartaoRepositoryDB.save(cartao));
    }

    public void deleteById(Long id) {
        cartaoRepositoryDB.deleteById(id);
    }
}
