package jba.service;

import jba.model.Blog;

public interface BlogService {
    public void save(Blog blog, String username);

    public Blog findById(int id);

    public void delete(Blog blog);

    public void reloadBlogs();

    Blog findByIdWithUser(int id);
}
