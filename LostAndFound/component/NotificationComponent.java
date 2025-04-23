package component;

import model.ItemInterface;
import service.ItemService;

public class NotificationComponent implements ItemDisplayer {
    private final ItemService service;

    public NotificationComponent(ItemService service) {
        this.service = service;
    }

    @Override
    public void displayAllItems() {
        System.out.println("\n-----------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                   |");
        System.out.println("|                                     DAFTAR LOST & FOUND ITEM                                      |");
        System.out.println("|                                                                                                   |");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                   |");
        System.out.printf("| %-15s | %-25s | %-20s | %-15s | %-10s |%n",
            "NAMA", "DESKRIPSI", "LOKASI", "KONTAK", "STATUS");
        System.out.println("|                                                                                                   |");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        for (ItemInterface item : service.getAllItems()) {
            System.out.println(item);
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");

    }
}
