package com.sensedia.sensezzaria.services;

import com.sensedia.sensezzaria.entidades.Pedido;
import com.sensedia.sensezzaria.repository.PedidoRepository;

import java.sql.SQLException;

public class PedidoService  {
    PedidoRepository pedidoRepository = new PedidoRepository();

    public Pedido createPedido() throws SQLException {
        return pedidoRepository.createPedido();
    }
}
