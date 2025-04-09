import javax.swing.*;
import java.awt.*;

public class LostAndFoundGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private FormPanel formPanel;
    private TablePanel tablePanel;
    private DashboardPanel dashboardPanel;

    public LostAndFoundGUI() {
        setTitle("Sistem Laporan Barang Hilang & Temuan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        formPanel = new FormPanel(this);
        tablePanel = new TablePanel(this);
        dashboardPanel = new DashboardPanel(this);

        mainPanel.add(dashboardPanel, "dashboard");
        mainPanel.add(formPanel, "form");
        mainPanel.add(tablePanel, "table");

        add(mainPanel);

        cardLayout.show(mainPanel, "dashboard");
        setVisible(true);
    }

    public void showFormPanel(String mode) {
        formPanel.setMode(mode);
        cardLayout.show(mainPanel, "form");
    }

    public void showDashboard() {
        cardLayout.show(mainPanel, "dashboard");
    }

    public void showTablePanel() {
        cardLayout.show(mainPanel, "table");
    }

    public void tambahLaporan(Barang barang) {
        tablePanel.addBarangToTable(barang);
        showTablePanel();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LostAndFoundGUI::new);
    }
}
