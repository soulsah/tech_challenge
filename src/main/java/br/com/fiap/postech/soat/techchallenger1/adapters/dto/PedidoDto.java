package br.com.fiap.postech.soat.techchallenger1.adapters.dto;

import br.com.fiap.postech.soat.techchallenger1.domain.model.Pedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.StatusPedido;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
    private Long id;
    private Long clienteId;
    private StatusPedido status;

    public PedidoDto(Pedido pedido){
        this.id = pedido.getId();
        this.clienteId = pedido.getClienteId();
        this.status = pedido.getStatus();
    }
}
