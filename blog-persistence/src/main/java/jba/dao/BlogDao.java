package jba.dao;

import jba.model.Blog;
import jba.model.User;

import java.util.List;

public interface BlogDao {
    public List<Blog> findByUser(User user);
    public void save(Blog blog);

    Blog findById(int id);

    void delete(Blog blog);

    List<Blog> findAll();
}
