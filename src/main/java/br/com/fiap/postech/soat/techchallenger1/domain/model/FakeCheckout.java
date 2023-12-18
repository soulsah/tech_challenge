package br.com.fiap.postech.soat.techchallenger1.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FakeCheckout {
    private Pedido pedido;
}
