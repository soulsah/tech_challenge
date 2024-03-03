package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Produto;
import br.com.fiap.postech.soat.techchallenger1.domain.model.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
    private Long id;
    private TipoProduto tipo;
    private String descricao;
    private BigDecimal preco;

    public ProdutoDto(Produto produto){
        this.id = produto.getId();
        this.tipo = produto.getTipo();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
    }
}
