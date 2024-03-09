package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Cartao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDto {

    @JsonProperty("numero_cartao")
    private String cardNumber;
    @JsonProperty("titular_cartao")
    private String cardHolderName;
    @JsonProperty("data_expiracao")
    private String expirationDate;
    @JsonProperty("codigo_seguranca")
    private String cvv;
    @JsonProperty("userId")
    private String userId;


    public CartaoDto(Cartao cartao){
        this.cardNumber = cartao.getCardNumber();
        this.cvv = cartao.getCvv();
        this.expirationDate = cartao.getExpirationDate();
        this.userId = ""+cartao.getUserId();
        this.cardHolderName = cartao.getCardHolderName();
    }
}
