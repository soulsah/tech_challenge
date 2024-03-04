package br.com.fiap.postech.soat.techchallenger1.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoPagamentoDto {
    private String id;
    private String status;
    private Double valorTotal;
    private String tipoPagamento;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("transaction_amount")
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @JsonProperty("payment_type")
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "NotificacaoPagamentoDto{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", valorTotal=" + valorTotal +
                ", tipoPagamento='" + tipoPagamento + '\'' +
                // outros campos
                '}';
    }
}
