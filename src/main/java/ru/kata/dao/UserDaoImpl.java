package ru.kata.dao;

import org.springframework.stereotype.Repository;
import ru.kata.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    @Override
    public void add(User user) {

    }

    @Override
    public List<User> users() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public void updateUser(int id, User user) {

    }
}
