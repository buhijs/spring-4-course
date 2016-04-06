package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

// TODO: Create a transactional repository bean implementing FoodRepository
@Repository
@Transactional
public class JpaFoodRepository implements FoodRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Food findFoodById(int id) {
        return em.find(Food.class, id);
    }

    @Override
    public List<Food> findAllFood() {
        List<Food> foodList = em.createQuery("select f from Food f").getResultList();
        return foodList;
    }

    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {
        Query query = em.createQuery("select d.food from DietEntry d where d.animalType = :animaltype");
        query.setParameter("animaltype", type);
        return query.getResultList();
    }

    @Override
    public void removeFood(Food food) {
        em.remove(food);
    }

    // TODO: implement findFoodById()

    // TODO: implement findAllFood()

    // TODO: implement findFoodForAnimalType()

    // TODO: implement removeFood()
}
