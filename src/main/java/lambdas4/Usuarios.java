package main.java.lambdas4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuarios {

    private final String jdbcUrl;

    public Usuarios(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    private void ejecutarEnTransaccion(AccionJdbc accion) throws SQLException {
        try (Connection connection = DriverManager.getConnection(this.jdbcUrl)){
            connection.setAutoCommit(false);
            try {
                accion.ejecutar(connection);
                connection.commit();
            }catch (SQLException e){
                connection.rollback();
                throw new RuntimeException("Error en la transacción, se realizo rollback", e);
            }
        } catch (SQLException e){
            throw new RuntimeException("Error de conexión", e);
        }
    }

    public void insertar(String nombre, String email) throws SQLException {
        ejecutarEnTransaccion(conexion -> {
            String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
            try (PreparedStatement st = conexion.prepareStatement(sql)){
                st.setString(1, nombre);
                st.setString(2, email);
                st.executeUpdate();
            }
        });
    }

    public void actualizarEmail(int id, String nuevoEmail) throws SQLException {
        ejecutarEnTransaccion(conexion -> {
            String sql = "UPDATE usuarios SET email = ? WHERE id = ?";
            try (PreparedStatement st = conexion.prepareStatement(sql)){
                st.setString(1, nuevoEmail);
                st.setInt(2, id);
                st.executeUpdate();
            }
        });
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