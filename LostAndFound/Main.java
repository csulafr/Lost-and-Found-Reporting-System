import component.*;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ItemService service = new ItemServiceImpl();

        LostItemReportComponent lostComp = new LostItemReportComponent(service);
        FoundItemInputComponent foundComp = new FoundItemInputComponent(service);
        MatchEngineComponent matchComp = new MatchEngineComponent(service);
        NotificationComponent notifComp = new NotificationComponent(service);

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("\n--------------------------------------------------------------");
            System.out.println("|                  LOST AND FOUND SISTEM                     |");
            System.out.println("--------------------------------------------------------------");
            System.out.println("| 1. LAPOR BARANG HILANG                                     |");
            System.out.println("| 2. LAPOR BARANG DITEMUKAN                                  |");
            System.out.println("| 3. TAMPILKAN SEMUA DATA                                    |");
            System.out.println("| 4. JALANKAN PENCOCOKAN                                     |");
            System.out.println("| 0. KELUAR                                                  |");
            System.out.println("--------------------------------------------------------------");
            System.out.print("\nMASUKKAN PILIHAN ANDA : ");
            int pilih = scanner.nextInt(); 
            scanner.nextLine(); // untuk konsumsi newline
        
            switch (pilih) {
                case 1 -> lostComp.reportLostItem();
                case 2 -> foundComp.reportFoundItem();
                case 3 -> notifComp.displayAllItems();
                case 4 -> matchComp.runMatching();
                case 0 -> {
                    loop = false;
                    System.out.println("\n--------------------------------------------------------------");
                    System.out.println("|     TERIMAKASIH TELAH MENGGUNAKAN SISTEM LOST AND FOUND    |");
                    System.out.println("--------------------------------------------------------------");
                }
                default -> System.out.println("❌ PILIHAN TIDAK TERSEDIA");
            }
        }
    }
}
