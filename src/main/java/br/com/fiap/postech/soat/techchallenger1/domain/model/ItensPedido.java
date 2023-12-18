package br.com.fiap.postech.soat.techchallenger1.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itens_pedido")
public class ItensPedido {
    @Id
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Id
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int Quantidade;

}
