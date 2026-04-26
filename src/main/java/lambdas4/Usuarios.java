package main.java.lambdas4;

import java.sql.*;

public class Usuarios {

    private final String jdbcUrl;

    public Usuarios(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    private void ejecutarUpdate(String sql, String msjError, PreparadorSQL preparador){
        try (Connection conn = DriverManager.getConnection(this.jdbcUrl);
            PreparedStatement ps = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            try {
                preparador.preparar(ps); // delego el seteo de datos a la Lambda
                ps.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(msjError, e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(msjError, e);
        }
    }

    public void insertar(String nombre, String email) {
        ejecutarUpdate(
                "INSERT INTO usuarios (nombre, email) VALUES (?, ?)",
                "Error al insertar usuario",
                ps -> {
                    ps.setString(1, nombre);
                    ps.setString(2, email);
                }
        );
    }

    public void actualizarEmail(int id, String nuevoEmail) {
        ejecutarUpdate(
                "UPDATE usuarios SET email = ? WHERE id = ?",
                "Error al actualizar usuario",
                ps -> {
                    ps.setString(1, nuevoEmail);
                    ps.setInt(2, id);
                }
        );
    }

//    public void insertar(String nombre, String email) {
//        try (Connection connection = DriverManager.getConnection(this.jdbcUrl);
//            PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (nombre, email) VALUES (?, ?)")) {
//            connection.setAutoCommit(false);
//            statement.setString(1, nombre);
//            statement.setString(2, email);
//            try {
//                statement.executeUpdate();
//                connection.commit();
//            } catch (SQLException e) {
//                connection.rollback();
//                throw new RuntimeException("Error al insertar usuario", e);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Error al insertar usuario", e);
//        }
//    }
//
//    public void actualizarEmail(int id, String nuevoEmail) {
//        try (Connection connection = DriverManager.getConnection(this.jdbcUrl);
//            PreparedStatement statement = connection.prepareStatement("UPDATE usuarios SET email = ? WHERE id = ?")) {
//            connection.setAutoCommit(false);
//            statement.setString(1, nuevoEmail);
//            statement.setInt(2, id);
//            try {
//                statement.executeUpdate();
//                connection.commit();
//            } catch (SQLException e) {
//                connection.rollback();
//                throw new RuntimeException("Error al actualizar usuario", e);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Error al actualizar usuario", e);
//        }
//    }
}