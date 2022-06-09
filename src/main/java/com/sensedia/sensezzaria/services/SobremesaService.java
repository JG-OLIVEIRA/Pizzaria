package com.sensedia.sensezzaria.services;

import com.sensedia.sensezzaria.entidades.Sobremesa;
import com.sensedia.sensezzaria.repository.SobremesaRepository;

import java.sql.SQLException;

public class SobremesaService {

    SobremesaRepository sobremesaRepository = new SobremesaRepository();

    public Sobremesa createSobremesa(String nome, Float valor) throws SQLException {
        return sobremesaRepository.createSobremesa(nome, valor);
    }
}
