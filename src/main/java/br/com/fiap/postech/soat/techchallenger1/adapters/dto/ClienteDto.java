package br.com.fiap.postech.soat.techchallenger1.adapters.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto{

    @JsonProperty
    @NotNull(message = "O cpf é um campo de preenchimento obrigatório")
    @NotEmpty
    @CPF
    private String cpf;

    @JsonProperty
    @NotNull(message = "O nome é um campo de preenchimento obrigatório")
    @NotEmpty
    private String nome;

    @JsonProperty
    @NotNull(message = "O e-mail é um campo de preenchimento obrigatório")
    @NotEmpty
    @Email
    private String email;
}
