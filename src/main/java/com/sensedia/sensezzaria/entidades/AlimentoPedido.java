package com.sensedia.sensezzaria.entidades;

public class AlimentoPedido {

    private Long id;
    private Long idPedido;
    private Long idBebida;
    private Long idPizza;
    private Long idSobremesa;

    public AlimentoPedido(){}

    public AlimentoPedido(Long id, Long idPedido, Long idBebida, Long idPizza, Long idSobremesa) {
        this.id = id;
        this.idPedido = idPedido;
        this.idBebida = idBebida;
        this.idPizza = idPizza;
        this.idSobremesa = idSobremesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Long idBebida) {
        this.idBebida = idBebida;
    }

    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public Long getIdSobremesa() {
        return idSobremesa;
    }

    public void setIdSobremesa(Long idSobremesa) {
        this.idSobremesa = idSobremesa;
    }
}
