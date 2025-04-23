package component;

import model.Item;
import service.ItemService;

import java.util.Scanner;

public class FoundItemInputComponent implements FoundItemReporter {
    private final ItemService service;

    public FoundItemInputComponent(ItemService service) {
        this.service = service;
    }

    @Override
    public void reportFoundItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------");
        System.out.println("|                  LAPOR BARANG DITEMUKAN                    |");
        System.out.println("--------------------------------------------------------------");
        System.out.print("Nama barang (Baju/Dompet/Kunci Motor/dan lainnya) : ");
        String name = scanner.nextLine();
        System.out.print("Deskripsi (Merek dan warna) : ");
        String desc = scanner.nextLine();
        System.out.print("Lokasi ditemukan : ");
        String location = scanner.nextLine();
        System.out.print("Kontak Anda : ");
        String contact = scanner.nextLine();

        Item item = new Item(name.trim(), desc.trim(), location.trim(), contact.trim(), "Ditemukan");
        service.addItem(item);

        System.out.println("--------------------------------------------------------------");
        System.out.println("|           ✔ BARANG DITEMUKAN BERHASIL DILAPORKAN           |");
        System.out.println("--------------------------------------------------------------");
    }
}
