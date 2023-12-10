package br.com.fiap.postech.soat.techchallenger1.domain.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private Long id;
    private String cpf;
    private String nome;
    private String email;
}
