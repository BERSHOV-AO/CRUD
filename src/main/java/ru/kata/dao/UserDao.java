package ru.kata.dao;

import ru.kata.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> users();

    User getUserById(int id);

    void deleteUserById(int id);

    void updateUser(int id, User user);
}
