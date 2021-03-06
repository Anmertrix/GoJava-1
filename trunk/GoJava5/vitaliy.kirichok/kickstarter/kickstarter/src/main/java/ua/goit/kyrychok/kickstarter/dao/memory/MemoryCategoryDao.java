package ua.goit.kyrychok.kickstarter.dao.memory;

import ua.goit.kyrychok.kickstarter.dao.CategoryDao;
import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.List;

public class MemoryCategoryDao implements CategoryDao {
    private MemoryStorage storage;

    public MemoryCategoryDao(MemoryStorage storage) {
        this.storage = storage;
    }

    @Override
    public String getWelcomeMessage() {
        return storage.getWelcomeMessage();
    }

    @Override
    public List<Category> fetch() {
        return storage.getCategories();
    }

    @Override
    public Category get(int id) {
        return storage.getCategory(id);
    }

    @Override
    public void add(Category category) {
        //TODO need implementation
    }
}
