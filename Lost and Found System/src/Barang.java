import java.util.Date;

public class Barang {
    private String nama;
    private String deskripsi;
    private String lokasi;
    private String kontak;
    private String pathGambar;
    private String status;
    private String kategori;
    private Date tanggalLaporan;
    private String kodeVerifikasi;

    public Barang(String nama, String deskripsi, String lokasi, String kontak, String pathGambar, String status, String kategori, Date tanggalLaporan, String kodeVerifikasi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.kontak = kontak;
        this.pathGambar = pathGambar;
        this.status = status;
        this.kategori = kategori;
        this.tanggalLaporan = tanggalLaporan;
        this.kodeVerifikasi = kodeVerifikasi;
    }

    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
    public String getLokasi() { return lokasi; }
    public String getKontak() { return kontak; }
    public String getPathGambar() { return pathGambar; }
    public String getStatus() { return status; }
    public String getKategori() { return kategori; }
    public Date getTanggalLaporan() { return tanggalLaporan; }
    public String getKodeVerifikasi() { return kodeVerifikasi; }

    public void setStatus(String status) { this.status = status; }
}
