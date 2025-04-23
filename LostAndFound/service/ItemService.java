package service;

import model.ItemInterface;
import java.util.List;

public interface ItemService {
    void addItem(ItemInterface item);
    List<ItemInterface> getAllItems();
    void matchItems();
}
