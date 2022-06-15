package com.sensedia.sensezzaria.entidades;

public class Pedido {

    private Long id;

    private Double total;

    public Pedido(){}

    public Pedido(Long id, Double total) {
        this.id = id;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}