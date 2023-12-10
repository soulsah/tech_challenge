package br.com.fiap.postech.soat.techchallenger1.domain.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private Long id;
    private Long cliente_id;
    private Enum<StatusPedido> status;
}
