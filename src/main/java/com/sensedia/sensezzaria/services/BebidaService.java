package com.sensedia.sensezzaria.services;

import com.sensedia.sensezzaria.entidades.Bebida;
import com.sensedia.sensezzaria.repository.BebidaRepository;

import java.sql.SQLException;

public class BebidaService {

    BebidaRepository bebidaRepository = new BebidaRepository();

    public Bebida createBebida(String nome, Float medida, Float valor) throws SQLException {
        return bebidaRepository.createBebida(nome, medida, valor);
    }

    public void deleteBebidaById(Integer id) throws SQLException{
        bebidaRepository.deleteBebidaById(id);
    }
}
