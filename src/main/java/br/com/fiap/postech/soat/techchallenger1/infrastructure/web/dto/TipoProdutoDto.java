package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;


import br.com.fiap.postech.soat.techchallenger1.domain.model.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoProdutoDto {

    private long id;
    private String descricao;

    public TipoProdutoDto(TipoProduto tipoProduto) {
        this.id=tipoProduto.getId();
        this.descricao = tipoProduto.getDescricao();
    }
}
