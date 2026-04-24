package main.java.lambdas4;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface AccionJdbc {
    void ejecutar(Connection conexion) throws SQLException;
}
