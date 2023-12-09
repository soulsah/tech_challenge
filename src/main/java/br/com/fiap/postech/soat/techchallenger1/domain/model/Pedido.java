package br.com.fiap.postech.soat.techchallenger1.domain.model;

public class Pedido {
    private Long id;
    private Long cliente_id;
    private Enum<StatusPedido> status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Enum<StatusPedido> getStatus() {
        return status;
    }

    public void setStatus(Enum<StatusPedido> status) {
        this.status = status;
    }
}
