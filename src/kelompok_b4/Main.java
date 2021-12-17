package kelompok_b4;

import kelompok_b4.exceptions.PelangganException;
import kelompok_b4.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static PelangganModel pelangganModel;
    static BajuModel bajuModels;
    static CelanaModel celanaModel;
    static RokModel rokModel;
    static PesananModel pesananModel;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            pelangganModel = new PelangganModel();
            bajuModels = new BajuModel();
            celanaModel = new CelanaModel();
            rokModel = new RokModel();
            pesananModel = new PesananModel();
            System.out.println("Koneksi Berhasil");

            String ulang = "";
            while (ulang.equals("")) {
                System.out.println("=====Menu Utama=====\n" +
                    "1. Pelanggan\n" +
                    "2. Pesanan\n" +
                    "0. Keluar");
                System.out.print("Pilih Menu : ");
                String pilihMenu = scanner.nextLine();

                switch (pilihMenu) {
                    case "0":
                        System.exit(0); break;
                    case "1":
                        System.out.println("ID Pelanggan  Nama       Alamat                         No. Telp");
                        menuLihatPelanggan();
                        System.out.println("=====Menu Pelanggan=====\n" +
                                "11. Tambah Pelanggan Baru\n" +
                                "12. Edit Data Pelanggan\n" +
                                "13. Hapus Data Pelanggan\n" +
                                "00. Kembali");
                        System.out.print("Pilih Menu : ");
                        String pilihMenuPelanggan = scanner.nextLine();
                        switch (pilihMenuPelanggan) {
                            case "11":
                                menuTambahPelanggan(); break;
                            case "12":
                                menuUpdatePelanggan(); break;
                            case "13":
                                menuDeletePelanggan(); break;
                        } break;
                    case "2":
                        System.out.println("=====Menu Pesanan=====\n" +
                                "21. Pesanan\n" +
                            "22. Catatan Ukuran Baju\n" +
                            "23. Catatan Ukuran Celana\n" +
                            "24. Catatan Ukuran Rok\n" +
                                "00. Kembali");
                        System.out.print("Pilih Menu : ");
                        String pilihPesanan = scanner.nextLine();
                        switch (pilihPesanan) {
                            case "21":
                                System.out.println("ID Pesanan  ID Pelanggan  ID Baju  ID Celana  ID Rok  Tgl-Pesan      Tgl-Ambil       Status Pesanan");
                                menuLihatPesanan();
                                System.out.println("=====Menu Pesanan=====\n" +
                                        "21a. Tambah Pesanan Baru\n" +
                                        "21b. Edit Pesanan\n" +
                                        "21c. Hapus Pesanan\n" +
                                        "00. Kembali");
                                System.out.print("Pilih Menu : ");
                                String pilihMenuPesanan = scanner.nextLine();
                                switch (pilihMenuPesanan) {
                                    case "21a":
                                        menuTambahPesanan(); break;
                                    case "21b":
                                        menuUpdatePesanan(); break;
                                    case "21c":
                                        menuDeletePesanan(); break;
                                } break;
                            case "22":
                                System.out.println("ID Baju  ID Pelanggan  Panjang Baju  Panjang Lengan  Panjang Bahu  oUjung Lengan  oDada  oKerah");
                                menuLihatCatatanBaju();
                                System.out.println("=====Ukuran Baju=====\n" +
                                    "22a. Tambah Ukuran Baju\n" +
                                    "22b. Edit Ukuran Baju\n" +
                                    "22c. Hapus Ukuran Baju\n" +
                                        "00. Kembali");
                                System.out.print("Pilih Menu : ");
                                String pilihMenuBaju = scanner.nextLine();
                                switch (pilihMenuBaju) {
                                    case "22a":
                                        menuTambahCatatanBaju(); break;
                                    case "22b":
                                        menuUpdateBaju(); break;
                                    case "22c":
                                        menuDeleteBaju(); break;
                                } break;
                            case "23":
                                System.out.println("ID Celana  ID Pelanggan  Panjang Celana  oPinggang  oPisak  oPaha  oUjung Celana");
                                menuLihatCatatanCelana();
                                System.out.println("=====Ukuran Celana=====\n" +
                                    "22a. Tambah Ukuran Celana\n" +
                                    "22b. Edit Ukuran Celana\n" +
                                    "22c. Hapus Ukuran Celana\n" +
                                        "00 Kembali");
                                System.out.print("Pilih Menu : ");
                                String pilihMenuCelana = scanner.nextLine();
                                switch (pilihMenuCelana) {
                                    case "23a":
                                        menuTambahCatatanCelana(); break;
                                    case "23b":
                                        menuUpdateCelana(); break;
                                    case "23c":
                                        menuDeleteCelana(); break;
                                } break;
                            case "24":
                                System.out.println("ID Rok  ID Pelanggan  Panjang Rok  oPinggang  oPanggul Tinggi Panggul");
                                menuLihatCatatanRok();
                                System.out.println("=====Ukuran Rok=====\n" +
                                        "24a. Tambah Ukuran Rok\n" +
                                        "24b. Edit Ukuran Rok\n" +
                                        "24c. Hapus Ukuran Rok\n" +
                                        "00. Kembali");
                                System.out.print("Pilih Menu : ");
                                String pilihMenuRok = scanner.nextLine();
                                switch (pilihMenuRok) {
                                    case "24a":
                                        menuTambahCatatanRok(); break;
                                    case "24b":
                                        menuUpdateRok(); break;
                                    case "24c":
                                        menuDeleteRok(); break;
                                } break;
                        } break;
                    default:
                        System.out.println("Pilihan Menu Tidak Tersedia");
                }
                System.out.print("Tekan Enter Untuk Menampilkan Menu... ");
                ulang = scanner.nextLine();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //pelanggan
    public static void  menuLihatPelanggan() throws SQLException {
        ResultSet lihatPelanggan = pelangganModel.getPelanggan();

        while (lihatPelanggan.next()) {
            System.out.print(lihatPelanggan.getString("id_pelanggan"));
            System.out.print("           ");
            System.out.print(lihatPelanggan.getString("nama"));
            System.out.print("      ");
            System.out.print(lihatPelanggan.getString("alamat"));
            System.out.print("       ");
            System.out.print(lihatPelanggan.getString("no_telp"));
            System.out.println();
        }
    }

    public static void menuTambahPelanggan() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan   : ");
            String id_pelanggan = scanner.nextLine();

            System.out.print("Nama Pelanggan : ");
            String nama = scanner.nextLine();

            System.out.print("Alamat         : ");
            String alamat = scanner.nextLine();

            System.out.print("No. Telepon    : ");
            String no_telp = scanner.nextLine();

            if (id_pelanggan.isEmpty() || nama.isEmpty() || alamat.isEmpty()) {
                throw new PelangganException();
            }
            int result = pelangganModel.addPelanggan(id_pelanggan, nama, alamat, no_telp);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }

        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void menuUpdatePelanggan() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan   : ");
            String id_pelanggan = scanner.nextLine();

            System.out.print("Nama Pelanggan : ");
            String nama = scanner.nextLine();

            System.out.print("Alamat         : ");
            String alamat = scanner.nextLine();

            System.out.print("No. Telepon    : ");
            String no_telp = scanner.nextLine();

            if (id_pelanggan.isEmpty() || nama.isEmpty() || alamat.isEmpty()) {
                throw new PelangganException();
            }
            int result = pelangganModel.updatePelanggan(id_pelanggan, nama, alamat, no_telp);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuDeletePelanggan() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan      : ");
            String id_pelanggan = scanner.nextLine();

            if (id_pelanggan.isEmpty()) {
                throw new PelangganException();
            }
            int result = pelangganModel.deletePelanggan(id_pelanggan);
            if (result > 0) {
                System.out.println("Berhasil menghapus " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }
    //Baju
    public static void  menuLihatCatatanBaju() throws SQLException {
        ResultSet lihatBaju = bajuModels.getBaju();

        while (lihatBaju.next()) {
            System.out.print(lihatBaju.getString("id_baju"));
            System.out.print("        ");
            System.out.print(lihatBaju.getString("id_pelanggan"));
            System.out.print("           ");
            System.out.print(lihatBaju.getString("p_baju"));
            System.out.print("            ");
            System.out.print(lihatBaju.getString("p_lengan"));
            System.out.print("              ");
            System.out.print(lihatBaju.getString("p_bahu"));
            System.out.print("            ");
            System.out.print(lihatBaju.getString("l_ujung_lengan"));
            System.out.print("             ");
            System.out.print(lihatBaju.getString("l_dada"));
            System.out.print("     ");
            System.out.print(lihatBaju.getString("l_kerah"));
            System.out.println();
        }
    }

    public static void menuTambahCatatanBaju() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan          : ");
            String id_pelanggan = scanner.nextLine();
            System.out.print("Panjang Baju          : ");
            String p_baju = scanner.nextLine();
            System.out.print("Panjang Lengan        : ");
            String p_lengan = scanner.nextLine();
            System.out.print("Panjang Bahu          : ");
            String p_bahu = scanner.nextLine();
            System.out.print("Lingkar Ujung Lengan  : ");
            String l_ujung_lengan = scanner.nextLine();
            System.out.print("lingkar Dada          : ");
            String l_dada = scanner.nextLine();
            System.out.print("Lingkar Kerah         : ");
            String l_kerah = scanner.nextLine();

            if (id_pelanggan.isEmpty() || p_baju.isEmpty() || l_dada.isEmpty()) {
                throw new PelangganException();
            }
            int result = bajuModels.addBaju(id_pelanggan, p_baju, p_lengan, p_bahu,  l_ujung_lengan, l_dada, l_kerah);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void menuUpdateBaju() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan          : ");
            String id_pelanggan = scanner.nextLine();
            System.out.print("Panjang Baju          : ");
            String p_baju = scanner.nextLine();
            System.out.print("Panjang Lengan        : ");
            String p_lengan = scanner.nextLine();
            System.out.print("Panjang Bahu          : ");
            String p_bahu = scanner.nextLine();
            System.out.print("Lingkar Ujung Lengan  : ");
            String l_ujung_lengan = scanner.nextLine();
            System.out.print("lingkar Dada          : ");
            String l_dada = scanner.nextLine();
            System.out.print("Lingkar Kerah         : ");
            String l_kerah = scanner.nextLine();

            if (id_pelanggan.isEmpty() || p_baju.isEmpty() || l_dada.isEmpty()) {
                throw new PelangganException();
            }
            int result = bajuModels.updateBaju(id_pelanggan, p_baju, p_lengan, p_bahu,  l_ujung_lengan, l_dada, l_kerah);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuDeleteBaju() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan      : ");
            String id_pelanggan = scanner.nextLine();

            if (id_pelanggan.isEmpty()) {
                throw new PelangganException();
            }
            int result = bajuModels.deleteBaju(id_pelanggan);
            if (result > 0) {
                System.out.println("Berhasil menghapus " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }
    //Celana
    public static void  menuLihatCatatanCelana() throws SQLException {
        ResultSet lihatCelana = celanaModel.getCelana();

        while (lihatCelana.next()) {
            System.out.print(lihatCelana.getString("id_celana"));
            System.out.print("          ");
            System.out.print(lihatCelana.getString("id_pelanggan"));
            System.out.print("           ");
            System.out.print(lihatCelana.getString("panjang_celana"));
            System.out.print("              ");
            System.out.print(lihatCelana.getString("l_pinggang"));
            System.out.print("         ");
            System.out.print(lihatCelana.getString("l_pisak"));
            System.out.print("      ");
            System.out.print(lihatCelana.getString("l_paha"));
            System.out.print("     ");
            System.out.print(lihatCelana.getString("l_ujung_celana"));
            System.out.println();
        }
    }

    public static void menuTambahCatatanCelana() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan          : ");
            String id_pelanggan = scanner.nextLine();
            System.out.print("Panjang Celana        : ");
            String panjang_celana = scanner.nextLine();
            System.out.print("Lingkar Pinggang      : ");
            String l_pinggang = scanner.nextLine();
            System.out.print("Lingkar Pisak         : ");
            String l_pisak = scanner.nextLine();
            System.out.print("Lingkar Paha          : ");
            String l_paha = scanner.nextLine();
            System.out.print("Lingkar Ujung Celana  : ");
            String l_ujung_celana = scanner.nextLine();

            if (id_pelanggan.isEmpty() || panjang_celana.isEmpty() || l_ujung_celana.isEmpty()) {
                throw new PelangganException();
            }
            int result = celanaModel.addCelana(id_pelanggan, panjang_celana, l_pinggang, l_pisak, l_paha, l_ujung_celana);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void menuUpdateCelana() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan          : ");
            String id_pelanggan = scanner.nextLine();
            System.out.print("Panjang Celana        : ");
            String panjang_celana = scanner.nextLine();
            System.out.print("Lingkar Pinggang      : ");
            String l_pinggang = scanner.nextLine();
            System.out.print("Lingkar Pisak         : ");
            String l_pisak = scanner.nextLine();
            System.out.print("Lingkar Paha          : ");
            String l_paha = scanner.nextLine();
            System.out.print("Lingkar Ujung Celana  : ");
            String l_ujung_celana = scanner.nextLine();

            if (id_pelanggan.isEmpty() || panjang_celana.isEmpty() || l_ujung_celana.isEmpty()) {
                throw new PelangganException();
            }
            int result = celanaModel.updateCelana(id_pelanggan, panjang_celana, l_pinggang, l_pisak, l_paha, l_ujung_celana);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuDeleteCelana() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan      : ");
            String id_pelanggan = scanner.nextLine();

            if (id_pelanggan.isEmpty()) {
                throw new PelangganException();
            }
            int result = celanaModel.deleteCelana(id_pelanggan);
            if (result > 0) {
                System.out.println("Berhasil menghapus " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }
    //Rok
    public static void  menuLihatCatatanRok() throws SQLException {
        ResultSet lihatRok = rokModel.getRok();

        while (lihatRok.next()) {
            System.out.print(lihatRok.getString("id_rok"));
            System.out.print("       ");
            System.out.print(lihatRok.getString("id_pelanggan"));
            System.out.print("           ");
            System.out.print(lihatRok.getString("p_rok"));
            System.out.print("           ");
            System.out.print(lihatRok.getString("l_pinggang"));
            System.out.print("         ");
            System.out.print(lihatRok.getString("l_panggul"));
            System.out.print("       ");
            System.out.print(lihatRok.getString("t_panggul"));
            System.out.println();
        }
    }

    public static void menuTambahCatatanRok() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan      : ");
            String id_pelanggan = scanner.nextLine();
            System.out.print("Panjang Rok       : ");
            String p_rok = scanner.nextLine();
            System.out.print("Lingkar Pinggang  : ");
            String l_pinggang = scanner.nextLine();
            System.out.print("Lingkar Panggul   : ");
            String l_panggul = scanner.nextLine();
            System.out.print("Tinggi Panggul    : ");
            String t_panggul = scanner.nextLine();

            if (id_pelanggan.isEmpty() || p_rok.isEmpty()) {
                throw new PelangganException();
            }
            int result = rokModel.addRok(id_pelanggan, p_rok, l_pinggang, l_panggul, t_panggul);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuUpdateRok() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan      : ");
            String id_pelanggan = scanner.nextLine();
            System.out.print("Panjang Rok       : ");
            String p_rok = scanner.nextLine();
            System.out.print("Lingkar Pinggang  : ");
            String l_pinggang = scanner.nextLine();
            System.out.print("Lingkar Panggul   : ");
            String l_panggul = scanner.nextLine();
            System.out.print("Tinggi Panggul    : ");
            String t_panggul = scanner.nextLine();

            if (id_pelanggan.isEmpty() || p_rok.isEmpty()) {
                throw new PelangganException();
            }
            int result = rokModel.updateRok(id_pelanggan, p_rok, l_pinggang, l_panggul, t_panggul);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuDeleteRok() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan      : ");
            String id_pelanggan = scanner.nextLine();

            if (id_pelanggan.isEmpty()) {
                throw new PelangganException();
            }
            int result = rokModel.deleteRok(id_pelanggan);
            if (result > 0) {
                System.out.println("Berhasil menghapus " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }
    //pesanan
    public static void  menuLihatPesanan() throws SQLException {
        ResultSet lihatPesanan = pesananModel.getPesanan();

        while (lihatPesanan.next()) {
            System.out.print(lihatPesanan.getString("id_pesanan"));
            System.out.print("           ");
            System.out.print(lihatPesanan.getString("id_pelanggan"));
            System.out.print("           ");
            System.out.print(lihatPesanan.getString("id_baju"));
            System.out.print("        ");
            System.out.print(lihatPesanan.getString("id_celana"));
            System.out.print("          ");
            System.out.print(lihatPesanan.getString("id_rok"));
            System.out.print("      ");
            System.out.print(lihatPesanan.getString("tgl_pesan"));
            System.out.print("     ");
            System.out.print(lihatPesanan.getString("tgl_ambil"));
            System.out.print("      ");
            System.out.print(lihatPesanan.getString("status_pesanan"));
            System.out.println();
        }
    }

    public static void menuTambahPesanan() {
        Scanner scanner = new Scanner(System.in);
        try {
            //(id_pelanggan, id_baju, id_celana, id_rok, tgl_pesan, tgl_ambil, status_pesanan)
            System.out.print("ID Pelanggan   : ");
            String id_pelanggan = scanner.nextLine();
            System.out.print("ID Baju        : ");
            String id_baju = scanner.nextLine();
            System.out.print("ID Celana      : ");
            String id_celana = scanner.nextLine();
            System.out.print("ID Rok         : ");
            String id_rok = scanner.nextLine();
            System.out.print("Tgl Pesan      : ");
            String tgl_pesan = scanner.nextLine();
            System.out.print("Tgl Ambil      : ");
            String tgl_ambil = scanner.nextLine();
            System.out.print("Status Pesanan : ");
            String status_pesanan = scanner.nextLine();

            if (id_pelanggan.isEmpty()) {
                throw new PelangganException();
            }
            int result = pesananModel.addPesanan(id_pelanggan, id_baju, id_celana, id_rok, tgl_pesan, tgl_ambil, status_pesanan);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void menuUpdatePesanan() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan   : ");
            String id_pelanggan = scanner.nextLine();
            System.out.print("ID Baju        : ");
            String id_baju = scanner.nextLine();
            System.out.print("ID Celana      : ");
            String id_celana = scanner.nextLine();
            System.out.print("ID Rok         : ");
            String id_rok = scanner.nextLine();
            System.out.print("Tgl Pesan      : ");
            String tgl_pesan = scanner.nextLine();
            System.out.print("Tgl Ambil      : ");
            String tgl_ambil = scanner.nextLine();
            System.out.print("Status Pesanan : ");
            String status_pesanan = scanner.nextLine();

            if (id_pelanggan.isEmpty()) {
                throw new PelangganException();
            }
            int result = pesananModel.updatePesanan(id_pelanggan, id_baju, id_celana, id_rok, tgl_pesan, tgl_ambil, status_pesanan);
            if (result > 0) {
                System.out.println("Berhasil update " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuDeletePesanan() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("ID Pelanggan      : ");
            String id_pelanggan = scanner.nextLine();

            if (id_pelanggan.isEmpty()) {
                throw new PelangganException();
            }
            int result = pesananModel.deletePesanan(id_pelanggan);
            if (result > 0) {
                System.out.println("Berhasil menghapus " + result + " baris");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        } catch (PelangganException e) {
            System.out.println(e.getMessage());
        }
    }
}
