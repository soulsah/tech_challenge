package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AutorizacaoDto {

    @JsonProperty("cpf")
    private String cpf;
}
