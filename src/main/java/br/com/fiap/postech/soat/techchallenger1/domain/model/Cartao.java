package br.com.fiap.postech.soat.techchallenger1.domain.model;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CartaoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "numero_cartao")
    private String cardNumber;
    @Column(name = "detentor_cartao")
    private String cardHolderName;
    @Column(name = "data_expiracao")
    private String expirationDate;
    @Column(name = "cvv")
    private String cvv;
    @JoinColumn(name = "user_id")
    private int userId;



    public Cartao(CartaoDto cartaoDto) {
        this.cardNumber = cartaoDto.getCardNumber();
        this.cvv = cartaoDto.getCvv();
        this.expirationDate = cartaoDto.getExpirationDate();
        this.userId = Integer.parseInt(cartaoDto.getUserId());
        this.cardHolderName = cartaoDto.getCardHolderName();
    }
}
