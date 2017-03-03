package home.elitej.repository;


import home.elitej.model.Restaurant;

import java.util.List;

public interface RestaurantRepository extends Dao<Restaurant> {

    List<Restaurant> selectBunchRestaurant(int fromId, int num);
}
