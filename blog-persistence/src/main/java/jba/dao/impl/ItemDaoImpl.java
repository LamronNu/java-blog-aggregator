package jba.dao.impl;

import jba.dao.ItemDao;
import jba.model.Blog;
import jba.model.Item;
import jba.model.pagination.PageRequest;
import jba.model.pagination.PageRequestImpl;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria getItemQuery() {
        return getCurrentSession().createCriteria(Item.class);
    }

    @Override
    public List<Item> findByBlog(Blog blog) {
        Criteria cr = getItemQuery();
        cr.add(Restrictions.eq("blog", blog));
        return cr.list();
    }

    @Override
    public void save(Item item) {
        getCurrentSession().save(item);
    }

    @Override
    public Item findByBlogAndLink(Blog blog, String link) {
        Criteria cr = getItemQuery();
        cr.add(Restrictions.eq("blog", blog));
        cr.add(Restrictions.eq("link", link));
        List<Item> results = cr.list();

        return results.size() == 0 ? null : results.get(0);
    }

    @Override
    public List<Item> findAll() {
        PageRequest pageRequest = new PageRequestImpl(1, DEFAULT_PAGE_SIZE, DEFAULT_SORT_ORDER);
        return findAll(pageRequest);
    }

    @Override
    public List<Item> findAll(PageRequest pageRequest) {
        Criteria query = getItemQuery();
        query.setMaxResults(pageRequest.getPageSize());
        query.setFirstResult(pageRequest.getFirstResult());
        pageRequest.setSortOrders(query);
        return query.list();
    }

    @Override
    public List<Item> findAll(int pageNumber) {
        PageRequest pageRequest = new PageRequestImpl(pageNumber, DEFAULT_PAGE_SIZE, DEFAULT_SORT_ORDER);
        return findAll(pageRequest);
    }

    @Override
    public int findCount() {
        Criteria query = getItemQuery();
        query.setProjection(Projections.rowCount());
        Number result = (Number) query.uniqueResult();
        return  result.intValue();
    }

}
