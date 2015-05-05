package jba.dao.impl;

import jba.dao.BlogDao;
import jba.model.Blog;
import jba.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BlogDaoImpl implements BlogDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Blog> findByUser(User user) {

        return (List<Blog>) getCurrentSession()
                .createQuery("from Blog WHERE user=" + user.getId())
                .list();
    }

    @Override
    public void save(Blog blog) {
        getCurrentSession().save(blog);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Blog findById(int id) {
        Blog blog = (Blog) getCurrentSession().load(
                Blog.class, id);
        return blog;
    }

    @Override
    public void delete(Blog blog) {
        getCurrentSession().delete(blog);
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) getCurrentSession()
                .createQuery("from Blog")
                .list();
    }
}
