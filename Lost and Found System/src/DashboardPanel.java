import javax.swing.*;
import java.awt.*;

class DashboardPanel extends JPanel {
    public DashboardPanel(LostAndFoundGUI parent) {
        setLayout(new BorderLayout(20, 20)); // gunakan BorderLayout agar bisa NORTH, CENTER
        setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        setBackground(new Color(240, 248, 255));

        // Judul di atas
        JLabel titleLabel = new JLabel("DASHBOARD LOST & FOUND", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Panel tombol di tengah
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 20, 20));
        centerPanel.setBackground(new Color(240, 248, 255));

        JButton btnMenemukan = new JButton("📦 SAYA MENEMUKAN BARANG 📦");
        JButton btnKehilangan = new JButton("❓ SAYA KEHILANGAN BARANG ❓");
        JButton btnLihatDaftar = new JButton("📋 DAFTAR BARANG LOST & FOUND 📋");

        Font font = new Font("SansSerif", Font.BOLD, 18);
        btnMenemukan.setFont(font);
        btnKehilangan.setFont(font);
        btnLihatDaftar.setFont(font);

        btnMenemukan.addActionListener(e -> parent.showFormPanel("menemukan"));
        btnKehilangan.addActionListener(e -> parent.showFormPanel("kehilangan"));
        btnLihatDaftar.addActionListener(e -> parent.showTablePanel());

        centerPanel.add(btnMenemukan);
        centerPanel.add(btnKehilangan);
        centerPanel.add(btnLihatDaftar);

        add(centerPanel, BorderLayout.CENTER);
    }
}
