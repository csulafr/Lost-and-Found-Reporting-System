package component;

import model.Item;
import service.ItemService;

import java.util.Scanner;

public class LostItemReportComponent implements LostItemReporter {
    private final ItemService service;

    public LostItemReportComponent(ItemService service) {
        this.service = service;
    }

    @Override
    public void reportLostItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------");
        System.out.println("|                  LAPOR BARANG HILANG                       |");
        System.out.println("--------------------------------------------------------------");
        System.out.print("Nama barang (Baju/Dompet/Kunci Motor/dan lainnya) : ");
        String name = scanner.nextLine();
        System.out.print("Deskripsi (Merek dan warna) : ");
        String description = scanner.nextLine();
        System.out.print("Lokasi : ");
        String location = scanner.nextLine();
        System.out.print("Kontak Anda : ");
        String contact = scanner.nextLine();

        Item item = new Item(name.trim(), description.trim(), location.trim(), contact.trim(), "Hilang");
        service.addItem(item);
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("|             ✔ BARANG HILANG BERHASIL DILAPORKAN            |");
        System.out.println("--------------------------------------------------------------");
    }
}
