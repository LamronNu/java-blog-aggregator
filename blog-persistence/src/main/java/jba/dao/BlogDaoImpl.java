package jba.dao;

import jba.entity.Blog;
import jba.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BlogDaoImpl implements BlogDao{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Blog> findByUser(User user) {
        return (List<Blog>) sessionFactory.getCurrentSession()
                .createQuery("from Blog WHERE id=" + user.getId())
                .list();
    }

    @Override
    public void save(Blog blog) {
        sessionFactory.getCurrentSession().save(blog);
    }
}
