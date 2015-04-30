package jba.service.impl;

import jba.dao.BlogDao;
import jba.dao.UserDao;
import jba.model.Blog;
import jba.model.User;
import jba.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BlogDao blogDao;

    @Override
    public void save(Blog blog, String username) {
        User user = userDao.findByUserName(username);
        blog.setUser(user);
        blogDao.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogDao.findById(id);
    }

    @Override
    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogDao.delete(blog);
    }
}
