package peaksoft.dao;

import peaksoft.model.Restaurant;

import java.util.List;

public interface RestaurantDao {
    void createRestaurant();
    String saveRestaurant(Long id,String name, String address, int openingYear);

    Restaurant findById(Long id);
    List<Restaurant> getAll();
    String deleteRestaurant();
    String updateRestaurant(Long id,Restaurant newRestaurant);

}
