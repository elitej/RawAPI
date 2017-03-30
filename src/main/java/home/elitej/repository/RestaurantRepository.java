package home.elitej.repository;


import home.elitej.model.entity.Restaurant;

import java.util.List;

public interface RestaurantRepository extends Dao<Restaurant> {

    List<Restaurant> selectOrderedBundle(int fromId, int num);
}
