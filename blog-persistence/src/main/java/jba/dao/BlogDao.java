package jba.dao;

import jba.entity.Blog;
import jba.entity.User;

import java.util.List;

public interface BlogDao {
    public List<Blog> findByUser(User user);

    public void save(Blog blog);
}
