package main.java.lambdas4;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparadorSQL {
    void preparar(PreparedStatement ps) throws SQLException;
}
