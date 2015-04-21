package jba.dao.impl;

import jba.dao.ItemDao;
import jba.model.Blog;
import jba.model.Item;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Item> findByBlog(Blog blog) {
        Session session = sessionFactory.getCurrentSession();
//        Criteria cr = session.createCriteria(Item.class);
//        cr.add(Restrictions.eq("blog", blog.getId()));
//        List<Item> results = cr.list();
        Query query = session
                .createQuery("FROM Item WHERE blog=" + blog.getId());
        List<Item> results = (List<Item>) query.list();
        return results;

    }

    @Override
    public void save(Item item) {
        sessionFactory.getCurrentSession().save(item);
    }
}
