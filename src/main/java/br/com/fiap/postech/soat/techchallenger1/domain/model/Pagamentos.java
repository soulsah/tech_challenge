package br.com.fiap.postech.soat.techchallenger1.domain.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_pagamento")
public class Pagamentos {
    @DynamoDBHashKey
    private long id;

    @DynamoDBAttribute
    public double valor;

    @DynamoDBAttribute
    private String status;

    @DynamoDBAttribute
    private long cardId;

    @DynamoDBHashKey
    private long pedidoId;



}
