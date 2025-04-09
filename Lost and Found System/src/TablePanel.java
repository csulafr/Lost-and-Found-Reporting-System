import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class TablePanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Barang> barangList = new ArrayList<>();

    public TablePanel(LostAndFoundGUI parent) {
        setLayout(new BorderLayout());
        setBackground(new Color(230, 255, 250));

        tableModel = new DefaultTableModel(new Object[]{"NAMA", "DESKRIPSI", "LOKASI", "KONTAK", "GAMBAR", "STATUS"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) return ImageIcon.class;
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5;
            }
        };

        table = new JTable(tableModel);
        table.setRowHeight(80);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.setGridColor(Color.LIGHT_GRAY);
        table.setBackground(Color.WHITE);

        // Dropdown untuk kolom status
        JComboBox<String> statusBox = new JComboBox<>(new String[]{"BELUM DIKLAIM", "SUDAH DIKLAIM"});
        table.getColumnModel().getColumn(5).setCellEditor(null);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Tombol kembali
        JButton btnKembali = new JButton("KEMBALI KE DASHBOARD");
        btnKembali.addActionListener(e -> parent.showDashboard());
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnKembali);
        add(bottomPanel, BorderLayout.SOUTH);

        // MouseListener untuk kolom status
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
        
                if (!table.isEditing() && row >= 0 && col == 5) { // kolom status
                    Barang barang = barangList.get(row);
                    String currentStatus = barang.getStatus();
                    String newStatus = currentStatus.equals("BELUM DIKLAIM") ? "SUDAH DIKEMBALIKAN" : "BELUM DIKLAIM";
        
                    String inputKode = JOptionPane.showInputDialog(TablePanel.this, "Masukkan kode verifikasi untuk mengubah status:");
                    if (inputKode == null) return;
        
                    if (inputKode.equals(barang.getKodeVerifikasi())) {
                        barang.setStatus(newStatus);
                        tableModel.setValueAt(newStatus, row, col);
                        JOptionPane.showMessageDialog(TablePanel.this, "STATUS BERHASIL DIUBAH.");
                    } else {
                        JOptionPane.showMessageDialog(TablePanel.this, "KODE VERIFIKASI SALAH! TIDAK DAPAT MENGUBAH STATUS.");
                    }
                }
            }
        });        
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addBarangToTable(Barang barang) {
        barangList.add(barang); // simpan ke daftar barang
        tableModel.addRow(new Object[]{
            barang.getNama(),
            barang.getDeskripsi(),
            barang.getLokasi(),
            barang.getKontak(),
            new ImageIcon(new ImageIcon(barang.getPathGambar()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
            barang.getStatus()
        });
    }
}
