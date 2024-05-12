package br.com.fiap.postech.soat.techchallenger1.domain.model;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ProdutoDto;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "tb_produto")
public class Produto {
    @DynamoDBHashKey
    private Long id;

    @DynamoDBAttribute
    private TipoProduto tipo;

    @DynamoDBAttribute
    private String descricao;

    @DynamoDBAttribute
    private BigDecimal preco;

    public Produto(ProdutoDto produtoDto){
        this.id = produtoDto.getId();
        this.tipo = produtoDto.getTipo();
        this.descricao = produtoDto.getDescricao();
        this.preco = produtoDto.getPreco();
    }
}
