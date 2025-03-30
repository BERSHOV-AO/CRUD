package ru.kata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.dao.UserDao;
import ru.kata.model.User;

import java.beans.Transient;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> users() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(int id) {
        return null;
    }

    @Transactional
    @Override
    public void deleteUserById(int id) {

    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {

    }
}
