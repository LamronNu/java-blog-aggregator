package jba.dao;

import jba.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public User findById(Integer id);
    public void save(User user);

    public User findByUserName(String username);

    void delete(int id);
}
