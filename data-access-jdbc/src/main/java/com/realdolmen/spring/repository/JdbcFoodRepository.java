package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.MeatyFood;
import com.realdolmen.spring.domain.VegiFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO: Implement the FoodRepository
@Repository
public class JdbcFoodRepository implements FoodRepository{
    // TODO: Inject a reference to your JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Food mapRow(ResultSet rs, int rowNum) throws SQLException{
        if(rs.getString("food_class").equals("MeatyFood")) {
            Food meatyFood = new MeatyFood();
            meatyFood.setId(rs.getInt("id"));
            meatyFood.setName(rs.getString("name"));
            meatyFood.setCalories(rs.getInt("calories"));
            return meatyFood;
        }
        else {
            Food fishFood = new VegiFood();
            fishFood.setId(rs.getInt("id"));
            fishFood.setName(rs.getString("name"));
            fishFood.setCalories(rs.getInt("calories"));
            return fishFood;
        }
    }

    // TODO: Implement findFoodById() and reuse your RowMapper
    @Override
    public Food findFoodById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM food WHERE id = ?", this::mapRow, id);
    }

    // TODO: Implement findAllFood() and create a RowMapper to make this easier!
    @Override
    public List<Food> findAllFood() {
        return jdbcTemplate.query("SELECT * FROM food", this::mapRow);
    }

    // TODO: Implement findFoodForAnimalType()
    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {
        return jdbcTemplate.query("SELECT * FROM food INNER JOIN animal_diet ON food.id=animal_diet.food_id WHERE animal_diet.animal_type = ?", this::mapRow, type.toString());
    }

    @Override
    public void addFoodForAnimalType(Animal.Type animalType, Food food) {

    }

    // TODO: Implement removeFood()
    @Override
    public void removeFood(Food food) {

    }



}
