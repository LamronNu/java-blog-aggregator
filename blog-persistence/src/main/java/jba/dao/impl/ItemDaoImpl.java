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
//        Criteria cr = session.createCriteria(Item.class);
//        cr.add(Restrictions.eq("blog", blog.getId()));
//        List<Item> results = cr.list();
        Query query = getCurrentSession()
                .createQuery("FROM Item WHERE blog=" + blog.getId());
        List<Item> results = query.list();
        return results;

    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Item item) {
        getCurrentSession().save(item);
    }

    @Override
    public Item findByBlogAndLink(Blog blog, String link) {
        Query query = getCurrentSession()
                .createQuery("from Item WHERE blog=? and link=?")
                .setParameter(0, blog.getId())
                .setParameter(1, link);
        return (Item) query.list().get(0);
    }
}
