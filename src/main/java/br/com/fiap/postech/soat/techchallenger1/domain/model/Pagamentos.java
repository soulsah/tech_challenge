package br.com.fiap.postech.soat.techchallenger1.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_pagamento")
public class Pagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "valor")
    public double valor;

    @Column(name = "status")
    private String status;

    @JoinColumn(name = "card_id")
    private long cardId;

    @JoinColumn(name = "pedidoId")
    private long pedidoId;



}
