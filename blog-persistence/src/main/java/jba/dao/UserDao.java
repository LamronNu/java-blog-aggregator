package jba.dao;

import jba.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public User findOne(Integer id);
    public void save(User user);
}
