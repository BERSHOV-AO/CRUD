package ru.kata.dao;

import org.springframework.stereotype.Repository;
import ru.kata.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }


    @Override
    public User showUser(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u where u.id =:id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<User> users() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void deleteUser(int id) {
        User user = showUser(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(int id, User update) {
        User user = showUser(id);
        user.setName(update.getName());
        user.setLastname(update.getLastname());
        user.setEmail(update.getEmail());
        entityManager.merge(user);
    }
}
