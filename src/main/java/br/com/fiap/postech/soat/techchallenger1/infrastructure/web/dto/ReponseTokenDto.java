package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReponseTokenDto implements Serializable {


    @JsonProperty("statusCode")
    private String statusCode;

}
