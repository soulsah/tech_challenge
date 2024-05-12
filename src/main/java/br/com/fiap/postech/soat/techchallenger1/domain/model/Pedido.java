package br.com.fiap.postech.soat.techchallenger1.domain.model;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.PedidoDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "Cliente_ID")
    private Long clienteId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusPedido status;

    public Pedido(PedidoDto pedidoDto){
        this.id = pedidoDto.getId();
        this.clienteId = pedidoDto.getClienteId();
        this.status = pedidoDto.getStatus();
    }
}
