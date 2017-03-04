package home.elitej.model.repository;

import home.elitej.model.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;


public class MockRestaurantRepositoryImpl implements RestaurantRepository {

    private final SortedMap<Integer, Restaurant> mockDb = new ConcurrentSkipListMap<>();

    {
        Restaurant restaurant1 = new Restaurant(1, "Shapokaense / Шапокоенсе", "Русская", "Казанская улица, 14",
                "+7 (812) 923-89-40", "07:00-22:00", "1.jpg");
        Restaurant restaurant2 = new Restaurant(2, "Shapokaense / Шапокоенсе", "Русская", "Казанская улица, 14",
                "+7 (812) 923-89-40", "07:00-22:00", "2.jpg");
        Restaurant restaurant3 = new Restaurant(3, "Shapokaense / Шапокоенсе", "Русская", "Казанская улица, 14",
                "+7 (812) 923-89-40", "07:00-22:00", "3.jpg");
        Restaurant restaurant4 = new Restaurant(4, "Shapokaense / Шапокоенсе", "Русская", "Казанская улица, 14",
                "+7 (812) 923-89-40", "07:00-22:00", "4.jpg");
        Restaurant restaurant5 = new Restaurant(5, "Shapokaense / Шапокоенсе", "Русская", "Казанская улица, 14",
                "+7 (812) 923-89-40", "07:00-22:00", "test.jpg");
        Restaurant restaurant6 = new Restaurant(6, "Shapokaense / Шапокоенсе", "Русская", "Казанская улица, 14",
                "+7 (812) 923-89-40", "07:00-22:00", "2.jpg");
        mockDb.put(1, restaurant1);
        mockDb.put(2, restaurant2);
        mockDb.put(3, restaurant3);
        mockDb.put(4, restaurant4);
        mockDb.put(5, restaurant5);
        mockDb.put(6, restaurant6);
    }

    @Override
    public boolean create(Restaurant restaurant) {
        return false;
    }

    @Override
    public Restaurant selectById(int id) {
        if (mockDb.containsKey(id))
            return mockDb.get(id);
        return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return null;
    }

    @Override
    public boolean removeById(int id) {
        return false;
    }

    @Override
    public List<Restaurant> selectOrderedBundle(int fromId, int num) {
        return new ArrayList<>(mockDb.subMap(fromId, fromId + num).values());
    }
}
