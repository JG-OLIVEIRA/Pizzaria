package com.sensedia.sensezzaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

        public Connection criaConexao() throws SQLException {
            return DriverManager
                    .getConnection("jdbc:mysql://localhost/sensezzaria?useTimezone=true&serverTimezone=UTC", "root", "root");
        }
}
