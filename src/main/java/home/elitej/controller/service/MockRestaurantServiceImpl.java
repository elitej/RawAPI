package home.elitej.controller.service;

import home.elitej.annotation.Inject;
import home.elitej.model.entity.Restaurant;
import home.elitej.model.repository.MockRestaurantRepositoryImpl;
import home.elitej.model.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;


public class MockRestaurantServiceImpl implements RestaurantService {

    @Inject
    private RestaurantRepository restaurantRepository = new MockRestaurantRepositoryImpl();

    @Override
    public boolean create(Restaurant restaurant) {
        return false;
    }

    @Override
    public Restaurant selectById(int id) {
        Restaurant restaurant = restaurantRepository.selectById(id);
        if (restaurant == null)
            throw new NoSuchElementException();
        return restaurant;
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
        return restaurantRepository.selectOrderedBundle(fromId, num);
    }
}
