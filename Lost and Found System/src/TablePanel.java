import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

class TablePanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Barang> barangList = new ArrayList<>();
    private JTextField lokasiFilter;
    private JTextField tanggalFilter;
    private JComboBox<String> kategoriFilter;

    public TablePanel(LostAndFoundGUI parent) {
        setLayout(new BorderLayout());
        setBackground(new Color(230, 255, 250));

        tableModel = new DefaultTableModel(new Object[]{
                "NAMA", "DESKRIPSI", "LOKASI", "KONTAK", "GAMBAR", "STATUS", "KATEGORI", "TANGGAL LAPORAN"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) return ImageIcon.class;
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        table.setRowHeight(80);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.setGridColor(Color.LIGHT_GRAY);
        table.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom button
        JButton btnKembali = new JButton("KEMBALI KE DASHBOARD");
        btnKembali.addActionListener(e -> parent.showDashboard());
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnKembali);
        add(bottomPanel, BorderLayout.SOUTH);

        // Filter Panel
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        kategoriFilter = new JComboBox<>(new String[]{"Semua", "Elektronik", "Dompet", "Kartu Identitas", "Lainnya"});
        lokasiFilter = new JTextField(10);
        tanggalFilter = new JTextField(10); // Format: dd-MM-yyyy

        JButton filterButton = new JButton("🔍 Filter");

        filterPanel.add(new JLabel("Kategori:"));
        filterPanel.add(kategoriFilter);
        filterPanel.add(new JLabel("Lokasi:"));
        filterPanel.add(lokasiFilter);
        filterPanel.add(new JLabel("Tanggal (dd-MM-yyyy):"));
        filterPanel.add(tanggalFilter);
        filterPanel.add(filterButton);

        add(filterPanel, BorderLayout.NORTH);

        // Filter logic
        filterButton.addActionListener(e -> applyFilter());

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
        
                if (!table.isEditing() && row >= 0 && col == 5) {
                    Barang barang = barangList.get(row);
                    String currentStatus = barang.getStatus();
                    String newStatus = currentStatus.equals("BELUM DIKLAIM") ? "SUDAH DIKEMBALIKAN" : "BELUM DIKLAIM";
        
                    String inputKode = JOptionPane.showInputDialog(TablePanel.this, "Masukkan kode verifikasi:");
                    if (inputKode == null) return;
        
                    if (inputKode.equals(barang.getKodeVerifikasi())) {
                        barang.setStatus(newStatus);
                        table.setValueAt(newStatus, row, col);
                        JOptionPane.showMessageDialog(TablePanel.this, "Status berhasil diubah.");
                    } else {
                        JOptionPane.showMessageDialog(TablePanel.this, "Kode verifikasi salah!");
                    }
                }
            }
        });
        
    }

    public void addBarangToTable(Barang barang) {
        barangList.add(barang); // simpan data asli
        refreshTable(barangList);
    }

    private void refreshTable(List<Barang> list) {
        tableModel.setRowCount(0); // hapus semua baris dulu
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

        for (Barang barang : list) {
            tableModel.addRow(new Object[]{
                    barang.getNama(),
                    barang.getDeskripsi(),
                    barang.getLokasi(),
                    barang.getKontak(),
                    new ImageIcon(new ImageIcon(barang.getPathGambar()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
                    barang.getStatus(),
                    barang.getKategori(),
                    sdf.format(barang.getTanggalLaporan())
            });
        }
    }

    private void applyFilter() {
        String kategori = (String) kategoriFilter.getSelectedItem();
        String lokasi = lokasiFilter.getText().trim().toLowerCase();
        String tanggalStr = tanggalFilter.getText().trim();

        SimpleDateFormat sdfInput = new SimpleDateFormat("dd-MM-yyyy");
        List<Barang> filtered = barangList.stream()
                .filter(b -> kategori.equals("Semua") || b.getKategori().equalsIgnoreCase(kategori))
                .filter(b -> lokasi.isEmpty() || b.getLokasi().toLowerCase().contains(lokasi))
                .filter(b -> {
                    if (tanggalStr.isEmpty()) return true;
                    try {
                        Date inputDate = sdfInput.parse(tanggalStr);
                        return sdfInput.format(b.getTanggalLaporan()).equals(sdfInput.format(inputDate));
                    } catch (Exception e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        refreshTable(filtered);
    }
}
