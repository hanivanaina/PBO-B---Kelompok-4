package kelompok_b4.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PelangganModel extends BaseModel{
    public PelangganModel() throws SQLException {
        super();
    }
    public int addPelanggan(String id_pelanggan, String nama, String alamat, String no_telp) throws SQLException {
        String query = "INSERT INTO pelanggan " +
                "(id_pelanggan, nama, alamat, no_telp)" +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);
        preparedStatement.setString(2, nama);
        preparedStatement.setString(3, alamat);
        preparedStatement.setString(4, no_telp);

        return preparedStatement.executeUpdate();
    }
    public ResultSet getPelanggan() throws SQLException {
        String query = "Select * FROM pelanggan";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public int updatePelanggan(String id_pelanggan, String nama, String alamat, String no_telp) throws SQLException {
        String query = "UPDATE pelanggan SET nama = ?, alamat = ?, no_telp = ? WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nama);
        preparedStatement.setString(2, alamat);
        preparedStatement.setString(3, no_telp);
        preparedStatement.setString(4, id_pelanggan);

        return preparedStatement.executeUpdate();
    }

    public int deletePelanggan(String id_pelanggan) throws SQLException {
        String query = "DELETE from pelanggan WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);

        return preparedStatement.executeUpdate();
    }
}
