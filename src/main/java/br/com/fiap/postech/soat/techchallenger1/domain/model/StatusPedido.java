package br.com.fiap.postech.soat.techchallenger1.domain.model;

public enum StatusPedido {
    RECEBIDO(1),
    EM_PREPARACAO(2),
    PRONTO(3),
    ENTREGUE(4);

    private final int value;

    private static final StatusPedido[] valores = values();

    StatusPedido(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StatusPedido fromValue(int value) {
        for (StatusPedido status : StatusPedido.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido para StatusPedido: " + value);
    }

    public StatusPedido next(){
        return valores[(this.ordinal() + 1 ) % valores.length];
    }
}
