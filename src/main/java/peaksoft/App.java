package peaksoft;

import peaksoft.model.Restaurant;
import peaksoft.service.RestaurantService;
import peaksoft.service.RestaurantServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RestaurantService restaurantService = new RestaurantServiceImpl();
       // restaurantService.createRestaurant();
       // System.out.println(restaurantService.saveRestaurant(4L, "Ala-Too", "Chuy", 2023));
      //  System.out.println(restaurantService.saveRestaurant(3L, "Amir", "Mira", 2022));
//        System.out.println(restaurantService.saveRestaurant(2L, "Royal", "Magistral", 2021));
     //   System.out.println(restaurantService.saveRestaurant(1L,"Etno",  "Kok-Jar",2024));
     //   System.out.println(restaurantService.updateRestaurant(1L, new Restaurant(2L, "Navat", "Sovetscay", 2021)));
     //   System.out.println(restaurantService.findById(2L));
      //  System.out.println(restaurantService.deleteRestaurant());
    }
}
