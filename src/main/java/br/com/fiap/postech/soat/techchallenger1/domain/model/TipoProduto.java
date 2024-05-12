package br.com.fiap.postech.soat.techchallenger1.domain.model;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.TipoProdutoDto;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamoDBTable(tableName = "tb_tipo_produto")
public class TipoProduto {
    @DynamoDBHashKey
    private Long id;

    @DynamoDBAttribute
    private String descricao;

    public TipoProduto(TipoProdutoDto tipoProdutoDto) {
        this.id = tipoProdutoDto.getId();
        this.descricao = tipoProdutoDto.getDescricao();
    }
}
