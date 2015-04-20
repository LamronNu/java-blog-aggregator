package jba.dao;

import jba.entity.Blog;
import jba.entity.Item;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao{
    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public List<Item> findByBlog(Blog blog) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM item WHERE id=" + blog.getId());
        return (List<Item>)query.list();

    }

    @Override
    public void save(Item item) {
        sessionFactory.getCurrentSession().save(item);
    }
}
