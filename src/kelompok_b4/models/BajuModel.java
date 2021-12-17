package kelompok_b4.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BajuModel extends BaseModel{
    public BajuModel() throws SQLException {
        super();
    }
    public int addBaju(String id_pelanggan, String p_baju, String p_lengan, String p_bahu,
                       String l_ujung_lengan, String l_dada, String l_kerah) throws SQLException {
        String query = "INSERT INTO baju " +
                "(id_pelanggan, p_baju, p_lengan, p_bahu, l_ujung_lengan, l_dada, l_kerah)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);
        preparedStatement.setString(2, p_baju);
        preparedStatement.setString(3, p_lengan);
        preparedStatement.setString(4, p_bahu);
        preparedStatement.setString(5, l_ujung_lengan);
        preparedStatement.setString(6, l_dada);
        preparedStatement.setString(7, l_kerah);

        return preparedStatement.executeUpdate();
    }
    public ResultSet getBaju() throws SQLException {
        String query = "Select * FROM baju";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public int updateBaju(String id_pelanggan, String p_baju, String p_lengan, String p_bahu,
                          String l_ujung_lengan, String l_dada, String l_kerah) throws SQLException {
        String query = "UPDATE baju SET p_baju = ?, p_lengan = ?, p_bahu = ?, l_ujung_lengan = ?, l_dada = ?, l_kerah =? WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, p_baju);
        preparedStatement.setString(2, p_lengan);
        preparedStatement.setString(3, p_bahu);
        preparedStatement.setString(4, l_ujung_lengan);
        preparedStatement.setString(5, l_dada);
        preparedStatement.setString(6, l_kerah);
        preparedStatement.setString(7, id_pelanggan);

        return preparedStatement.executeUpdate();
    }

    public int deleteBaju(String id_pelanggan) throws SQLException {
        String query = "DELETE from baju WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);

        return preparedStatement.executeUpdate();
    }
}
