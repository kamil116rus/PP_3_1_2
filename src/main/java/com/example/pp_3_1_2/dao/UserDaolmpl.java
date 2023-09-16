package com.example.pp_3_1_2.dao;

import com.example.pp_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
@Transactional
public class UserDaolmpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaolmpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
   // @SuppressWarnings("uncheked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User user) {
        // entityManager.getTransaction().begin();
        entityManager.merge(user);

    }
}
