package br.com.fiap.postech.soat.techchallenger1.adapters.dto;

import br.com.fiap.postech.soat.techchallenger1.domain.model.FilaPedido;
import br.com.fiap.postech.soat.techchallenger1.domain.model.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilaPedidoDto {
    private Long pedidoId;
    private Long clienteId;
    private StatusPedido statusPedido;

    public FilaPedidoDto(FilaPedido filaPedido){
        this.pedidoId = filaPedido.getPedidoId();
        this.clienteId = filaPedido.getClienteId();
        this.statusPedido = filaPedido.getStatusPedido();
    }
}
