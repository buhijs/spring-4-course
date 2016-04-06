package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

// TODO: implement AnimalRepository
// TODO: create a transactional repository bean from this class

@Repository
@Transactional
public class JpaAnimalRepository implements AnimalRepository{
    // TODO: inject a persistence context
    @PersistenceContext
    private EntityManager em;

    // TODO: implement create()
    @Override
    public void create(Animal animal) {
        em.persist(animal);
    }

    // TODO: implement findById()
    @Override
    public Animal findById(int id) {
        return em.find(Animal.class, id);
    }

    // TODO: implement findAll()
    @Override
    public List<Animal> findAll() {
        return em.createQuery("select a from Animal a", Animal.class).getResultList();
    }


    // TODO: implement update()
    @Override
    public void update(Animal animal) {
        em.merge(animal);
    }

    // TODO: implement delete()
    @Override
    public void remove(Animal animal) {
        em.remove(animal);
    }
}
