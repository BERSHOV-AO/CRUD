package ru.kata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.dao.UserDao;
import ru.kata.model.User;

import java.beans.Transient;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public UserServiceImpl (UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> users() {
        return userDao.users();
    }


    @Transactional(readOnly = true)
    @Override
    public User showUser(int id) {
        return userDao.showUser(id);
    }


    @Transactional
    @Override
    public void remove(int id) {
        userDao.remove(id);
    }


    @Transactional
    @Override
    public void update(int id, User user) {
        userDao.update(id, user);

    }

}
