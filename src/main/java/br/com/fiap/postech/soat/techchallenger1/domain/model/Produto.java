package br.com.fiap.postech.soat.techchallenger1.domain.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private Long id;
    private String descricao;
    private Float preco;
}
