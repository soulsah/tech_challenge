package br.com.fiap.postech.soat.techchallenger1.domain.model;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.CartaoDto;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_cartao")
public class Cartao {

    @DynamoDBHashKey
    private long id;

    @DynamoDBAttribute
    private String cardNumber;

    @DynamoDBAttribute
    private String cardHolderName;

    @DynamoDBAttribute
    private String expirationDate;

    @DynamoDBAttribute
    private String cvv;

    @DynamoDBAttribute
    private int userId;



    public Cartao(CartaoDto cartaoDto) {
        this.cardNumber = cartaoDto.getCardNumber();
        this.cvv = cartaoDto.getCvv();
        this.expirationDate = cartaoDto.getExpirationDate();
        this.userId = Integer.parseInt(cartaoDto.getUserId());
        this.cardHolderName = cartaoDto.getCardHolderName();
    }
}
