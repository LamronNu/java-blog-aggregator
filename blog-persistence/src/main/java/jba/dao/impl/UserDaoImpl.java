package jba.dao.impl;

import jba.dao.UserDao;
import jba.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //@SuppressWarnings("unchecked")
    public List<User> findAll() {
        return (List<User>) getCurrentSession()
                .createQuery("from User")
                .list();
    }

    @Override
    public User findOne(Integer id) {
        User user = (User) getCurrentSession().load(
                User.class, id);

        return user;
    }

    @Override
    public void save(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public User findByUserName(String username) {
        Query query = getCurrentSession()
                .createQuery("from User where name=?")
                .setParameter(0, username);
        List<User> users = query.list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void delete(int id) {
        getCurrentSession().delete(findOne(id));
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
