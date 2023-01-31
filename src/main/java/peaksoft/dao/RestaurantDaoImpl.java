package peaksoft.dao;

import peaksoft.model.Restaurant;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDaoImpl implements RestaurantDao{
    Connection connection;
    public RestaurantDaoImpl(){
        this.connection = Util.getConnection();
    }
    @Override
    public void createRestaurant() {
        String query = """
                create table restaurants(
                id serial primary key,
                name varchar,
                address varchar,
                opening_year int)
                """;
        try ( Statement statement = connection.createStatement();){
            statement.executeUpdate(query);
            System.out.println("Successfully created");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        return "Successfully created";
    }

    @Override
    public String saveRestaurant( Long id,String name, String address, int openingYear) {
        String query = """
                insert into (
                id, name, address, openingYear) values (? ? ? ?);
                """;
        try (Connection connection1 = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
            preparedStatement.setLong(1,id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, address);
            preparedStatement.setInt(4, openingYear);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "saved";
    }
    @Override
    public Restaurant findById(Long id) {
        String query = """
                select * from restaurant where id = ?;
                """;
        try ( Connection connection1 = Util.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setLong(1, id);
            ResultSet resultSet =  preparedStatement.executeQuery();
            Restaurant restaurant = new Restaurant();
            while (resultSet.next()) {
               restaurant.setName(resultSet.getString(1));
               restaurant.setAddress(resultSet.getString(2));
               restaurant.setOpeningYear(resultSet.getInt(3));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant();
        String query = """
                select * from restaurants;
                """;
        try (  Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
            restaurant.setName(resultSet.getString(1));
            restaurant.setAddress(resultSet.getString(2));
            restaurant.setOpeningYear(resultSet.getInt(3));
            restaurants.add(restaurant);
         }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return restaurants;
    }

    @Override
    public String deleteRestaurant() {
        String query = """
                drop table  restaurants;
                """;

        try(   Statement statement = connection.createStatement();) {
            statement.execute(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Deleted";
    }

    @Override
    public String updateRestaurant(Long id,Restaurant newRestaurant) {
        String query = """
                update  restaurants set name = ?,
                address = ?,
                openingYear = ?, where id = ?;
                """;
        try( PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, newRestaurant.getName());
            preparedStatement.setString(2,newRestaurant.getAddress());
            preparedStatement.setInt(3,newRestaurant.getOpeningYear());
            int r = preparedStatement.executeUpdate();
            if(r > 0){
                System.out.println("Updated successfully ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Successfully updated";
    }


}
