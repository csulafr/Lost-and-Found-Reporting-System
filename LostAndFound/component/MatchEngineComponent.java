package component;

import service.ItemService;

public class MatchEngineComponent implements MatchRunner {
    private final ItemService service;

    public MatchEngineComponent(ItemService service) {
        this.service = service;
    }

    @Override
    public void runMatching() {
        service.matchItems();
    }
}
