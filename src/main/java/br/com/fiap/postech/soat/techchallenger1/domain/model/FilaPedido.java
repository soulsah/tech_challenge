package br.com.fiap.postech.soat.techchallenger1.domain.model;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.FilaPedidoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_fila_pedidos")
@IdClass(FilaPedidoId.class)
public class FilaPedido {
    @Id
    @JoinColumn(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @Id
    @JoinColumn(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "status", nullable = false)
    private StatusPedido statusPedido;

    public FilaPedido(FilaPedidoDto filaPedidoDto){
        this.pedidoId = filaPedidoDto.getPedidoId();
        this.clienteId = filaPedidoDto.getClienteId();
        this.statusPedido = filaPedidoDto.getStatusPedido();
    }
}
