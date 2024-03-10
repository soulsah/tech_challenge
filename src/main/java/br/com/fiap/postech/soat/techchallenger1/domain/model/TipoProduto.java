package br.com.fiap.postech.soat.techchallenger1.domain.model;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.TipoProdutoDto;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tb_tipo_produto")
public class TipoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    public TipoProduto(TipoProdutoDto tipoProdutoDto) {
        this.id = tipoProdutoDto.getId();
        this.descricao = tipoProdutoDto.getDescricao();
    }
}
