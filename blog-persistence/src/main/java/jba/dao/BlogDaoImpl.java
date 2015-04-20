package jba.dao;

import jba.entity.Blog;
import jba.entity.User;
import jba.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDaoImpl implements BlogDao{

    //@Autowired
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public List<Blog> findByUser(User user) {
        return (List<Blog>) sessionFactory.getCurrentSession()
                .createQuery("from blog")
                .list();
    }

    @Override
    public void save(Blog blog) {
        sessionFactory.getCurrentSession().save(blog);
    }
}
