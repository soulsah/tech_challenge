package br.com.fiap.postech.soat.techchallenger1.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_itens_pedido")
public class ItensPedido {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "produto", nullable = false)
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private int Quantidade;

}
