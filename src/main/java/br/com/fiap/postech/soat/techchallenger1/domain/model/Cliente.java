package br.com.fiap.postech.soat.techchallenger1.domain.model;


import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ClienteDto;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "tb_cliente")
public class Cliente {

    @DynamoDBHashKey
    private Long id;

    @DynamoDBAttribute
    private String cpf;
    @DynamoDBAttribute
    private String nome;
    @DynamoDBAttribute
    private String email;

    public Cliente(ClienteDto clienteDto) {
        this.id= 1L;
        this.cpf = clienteDto.getCpf();
        this.nome = clienteDto.getNome();
        this.email = clienteDto.getEmail();
    }


}
