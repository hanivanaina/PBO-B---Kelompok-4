package kelompok_b4.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PesananModel extends BaseModel{
    public PesananModel() throws SQLException {
        super();
    }
    public int addPesanan(String id_pelanggan, String id_baju, String id_celana, String id_rok, String tgl_pesan, String tgl_ambil, String status_pesanan) throws SQLException {
        String query = "INSERT INTO pesanan " +
                "(id_pelanggan, id_baju, id_celana, id_rok, tgl_pesan, tgl_ambil, status_pesanan)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);
        preparedStatement.setString(2, id_baju);
        preparedStatement.setString(3, id_celana);
        preparedStatement.setString(4, id_rok);
        preparedStatement.setString(5, tgl_pesan);
        preparedStatement.setString(6, tgl_ambil);
        preparedStatement.setString(7, status_pesanan);

        return preparedStatement.executeUpdate();
    }
    public ResultSet getPesanan() throws SQLException {
        String query = "Select * FROM pesanan";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
    public int updatePesanan(String id_pelanggan, String id_baju, String id_celana, String id_rok, String tgl_pesan, String tgl_ambil, String status_pesanan) throws SQLException {
        String query = "UPDATE pesanan SET id_baju = ?, id_celana = ?, id_rok = ?, tgl_pesan =?, tgl_ambil=?, status_pesanan = ? WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_baju);
        preparedStatement.setString(2, id_celana);
        preparedStatement.setString(3, id_rok);
        preparedStatement.setString(4, tgl_pesan);
        preparedStatement.setString(5, tgl_ambil);
        preparedStatement.setString(6, status_pesanan);
        preparedStatement.setString(7, id_pelanggan);

        return preparedStatement.executeUpdate();
    }

    public int deletePesanan(String id_pelanggan) throws SQLException {
        String query = "DELETE from pesanan WHERE id_pelanggan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id_pelanggan);

        return preparedStatement.executeUpdate();
    }
}
