package jba.dao.impl;

import jba.dao.ItemDao;
import jba.model.Blog;
import jba.model.Item;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        Criteria cr = getCurrentSession().createCriteria(Item.class);
        cr.add(Restrictions.eq("blog", blog));
        cr.add(Restrictions.eq("link", link));
        List<Item> results = cr.list();

//        Query query = getCurrentSession()
//                .createQuery("from Item WHERE blog=? and link=?")
//                .setParameter(0, blog.getId())
//                .setParameter(1, link);

//        List<Item> list = query.list();

        return results.size() == 0 ? null : results.get(0);
    }

    @Override
    public List<Item> findAll() {
        return (List<Item>) getCurrentSession().createQuery("from Item order by published_date desc").list();//to do better
    }
}
