package service;

import model.Item;
import model.ItemInterface;
import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    private List<ItemInterface> itemList = new ArrayList<>();

    @Override
    public void addItem(ItemInterface item) {
        itemList.add(item);
    }

    @Override
    public List<ItemInterface> getAllItems() {
        return itemList;
    }

    private boolean isSimilar(ItemInterface lost, ItemInterface found) {
        boolean nameMatch = lost.getName().equalsIgnoreCase(found.getName());
        boolean locationMatch = lost.getLocation().toLowerCase().contains(found.getLocation().toLowerCase()) ||
                                found.getLocation().toLowerCase().contains(lost.getLocation().toLowerCase());
        boolean descMatch = lost.getDescription().toLowerCase().contains(found.getDescription().toLowerCase()) ||
                            found.getDescription().toLowerCase().contains(lost.getDescription().toLowerCase());
        return nameMatch && locationMatch && descMatch;
    }

    @Override
    public void matchItems() {
        for (ItemInterface lost : itemList) {
            if (!lost.getStatus().equalsIgnoreCase("Hilang")) continue;
            for (ItemInterface found : itemList) {
                if (!found.getStatus().equalsIgnoreCase("Ditemukan")) continue;
                if (isSimilar(lost, found)) {
                    lost.setStatus("Cocok");
                    found.setStatus("Cocok");
                    System.out.println("\n~ MATCHED ~ ");
                    System.out.println("BARANG : " + lost.getName() +
                            " | PEMILIK : " + lost.getContact() +
                            " | PENEMU : " + found.getContact());
                }
            }
        }
    }
}
