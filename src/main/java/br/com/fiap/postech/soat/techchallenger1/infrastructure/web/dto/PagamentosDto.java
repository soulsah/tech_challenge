package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pagamentos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentosDto {
    private long id;

    public double valor;

    private String status;

    public PagamentosDto(Pagamentos pagamentos){
        this.id = pagamentos.getId();
        this.valor = pagamentos.getValor();
        this.status = pagamentos.getStatus();
    }

}
