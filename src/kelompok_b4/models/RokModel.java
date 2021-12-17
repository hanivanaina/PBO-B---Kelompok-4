package kelompok_b4.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RokModel extends BaseModel{
    public RokModel() throws SQLException {
        super();
    }
    public int addRok(String id_pelanggan, String p_rok, String l_pinggang, String l_panggul,
                         String t_panggul) throws SQLException {
        String query = "INSERT INTO rok " +
                "(id_pelanggan, p_rok, l_pinggang, l_panggul, t_panggul)" +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);
        preparedStatement.setString(2, p_rok);
        preparedStatement.setString(3, l_pinggang);
        preparedStatement.setString(4, l_panggul);
        preparedStatement.setString(5, t_panggul);

        return preparedStatement.executeUpdate();
    }
    public ResultSet getRok() throws SQLException {
        String query = "Select * FROM rok";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public int updateRok(String id_pelanggan, String p_rok, String l_pinggang, String l_panggul,
                         String t_panggul) throws SQLException {
        String query = "UPDATE rok SET p_rok = ?, l_pinggang = ?, l_panggul = ?, t_panggul = ? WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, p_rok);
        preparedStatement.setString(2, l_pinggang);
        preparedStatement.setString(3, l_panggul);
        preparedStatement.setString(4, t_panggul);
        preparedStatement.setString(5, id_pelanggan);

        return preparedStatement.executeUpdate();
    }

    public int deleteRok(String id_pelanggan) throws SQLException {
        String query = "DELETE from rok WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);

        return preparedStatement.executeUpdate();
    }
}
