package home.elitej.service;

import home.elitej.model.Restaurant;

import java.util.List;

public interface RestaurantService extends AbstractService<Restaurant>{
    List<Restaurant> selectBunchRestaurant(int fromId, int num);
}
