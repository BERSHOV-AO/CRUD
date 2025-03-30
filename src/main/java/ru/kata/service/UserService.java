package ru.kata.service;

import ru.kata.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> users();

    User getUserById(int id);

    void deleteUserById(int id);

    void updateUser(int id, User user);


}
