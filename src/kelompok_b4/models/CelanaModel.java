package kelompok_b4.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CelanaModel extends BaseModel{
    public CelanaModel() throws SQLException {
        super();
    }

    public int addCelana(String id_pelanggan, String panjang_celana, String l_pinggang, String l_pisak,
                       String l_paha, String l_ujung_celana) throws SQLException {
        String query = "INSERT INTO celana " +
                "(id_pelanggan, panjang_celana, l_pinggang, l_pisak, l_paha, l_ujung_celana)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);
        preparedStatement.setString(2, panjang_celana);
        preparedStatement.setString(3, l_pinggang);
        preparedStatement.setString(4, l_pisak);
        preparedStatement.setString(5, l_paha);
        preparedStatement.setString(6, l_ujung_celana);

        return preparedStatement.executeUpdate();
    }
    public ResultSet getCelana() throws SQLException {
        String query = "Select * FROM celana";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public int updateCelana(String id_pelanggan, String panjang_celana, String l_pinggang, String l_pisak,
                            String l_paha, String l_ujung_celana) throws SQLException {
        String query = "UPDATE celana SET panjang_celana = ?, l_pinggang = ?, l_pisak = ?, l_paha = ?, l_ujung_celana = ? WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, panjang_celana);
        preparedStatement.setString(2, l_pinggang);
        preparedStatement.setString(3, l_pisak);
        preparedStatement.setString(4, l_paha);
        preparedStatement.setString(5, l_ujung_celana);
        preparedStatement.setString(7, id_pelanggan);

        return preparedStatement.executeUpdate();
    }

    public int deleteCelana(String id_pelanggan) throws SQLException {
        String query = "DELETE from celana WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);

        return preparedStatement.executeUpdate();
    }
}
