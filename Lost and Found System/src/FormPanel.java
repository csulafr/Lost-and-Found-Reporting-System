import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class FormPanel extends JPanel {
    private LostAndFoundGUI mainFrame;
    private JTextField namaField, deskripsiField, lokasiField, kontakField, kodeVerifikasiField;
    private JComboBox<String> statusComboBox, kategoriComboBox;
    private String pathGambar = "";

    public FormPanel(LostAndFoundGUI mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(0, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel namaLabel = new JLabel("NAMA BARANG :");
        namaField = new JTextField(20);
        add(namaLabel);
        add(namaField);

        JLabel deskripsiLabel = new JLabel("DESKRIPSI BARANG :");
        deskripsiField = new JTextField(20);
        add(deskripsiLabel);
        add(deskripsiField);

        JLabel lokasiLabel = new JLabel("LOKASI BARANG DITEMUKAN :");
        lokasiField = new JTextField(20);
        add(lokasiLabel);
        add(lokasiField);

        JLabel kontakLabel = new JLabel("KONTAK YG DAPAT DIHUBUNGI :");
        kontakField = new JTextField(20);
        add(kontakLabel);
        add(kontakField);

        JLabel statusLabel = new JLabel("STATUS :");
        statusComboBox = new JComboBox<>(new String[]{"HILANG", "DITEMUKAN"});
        add(statusLabel);
        add(statusComboBox);

        JLabel kategoriLabel = new JLabel("KATEGORI BARANG :");
        kategoriComboBox = new JComboBox<>(new String[]{"ELEKTRONIK", "DOKUMEN", "PAKAIAN", "LAINNYA"});
        add(kategoriLabel);
        add(kategoriComboBox);

        JLabel gambarLabel = new JLabel("PATH GAMBAR :");
        JButton pilihGambarBtn = new JButton("PILIH GAMBAR");
        pilihGambarBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(FormPanel.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                pathGambar = fileChooser.getSelectedFile().getAbsolutePath();
            }
        });
        add(gambarLabel);
        add(pilihGambarBtn);

        JLabel kodeVerifikasiLabel = new JLabel("KODE VERIFIKASI :");
        kodeVerifikasiField = new JTextField(20);
        add(kodeVerifikasiLabel);
        add(kodeVerifikasiField);

        JButton simpanBtn = new JButton("TAMBAH BARANG");
        simpanBtn.addActionListener(e -> {
            if (kodeVerifikasiField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "KODE VERIFIKASI TIDAK BOLEH KOSONG.");
                return;
            }
        
            Barang barang = new Barang(
                namaField.getText(),
                deskripsiField.getText(),
                lokasiField.getText(),
                kontakField.getText(),
                pathGambar,
                statusComboBox.getSelectedItem().toString(),
                kategoriComboBox.getSelectedItem().toString(),
                new Date(),
                kodeVerifikasiField.getText()
            );
        
            mainFrame.tambahLaporan(barang);
            resetForm(); // reset setelah tambah
        });
        

        JButton kembaliBtn = new JButton("KEMBALI KE DASHBOARD");
        kembaliBtn.addActionListener(e -> {
            mainFrame.showDashboard();
        });

        add(kembaliBtn);
        add(simpanBtn);
    }

    // Tambahkan di bawah constructor
    public void resetForm() {
        namaField.setText("");
        deskripsiField.setText("");
        lokasiField.setText("");
        kontakField.setText("");
        pathGambar = "";
        statusComboBox.setSelectedIndex(0);
        kategoriComboBox.setSelectedIndex(0);
        kodeVerifikasiField.setText("");
    }

    public void setMode(String mode) {
        // Belum dipakai, bisa digunakan nanti untuk "edit" atau "tambah"
    }
}
