package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDto {

    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;
    private String userId;


    public CartaoDto(Cartao cartao){
        this.cardNumber = cartao.getCardNumber();
        this.cvv = cartao.getCvv();
        this.expirationDate = cartao.getExpirationDate();
        this.userId = cartao.getUserId();
        this.cardHolderName = cartao.getCardHolderName();
    }
}
