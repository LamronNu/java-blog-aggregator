package jba.dao;

import jba.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //@SuppressWarnings("unchecked")
    public List<User> findAll() {
        return (List<User>) sessionFactory.getCurrentSession()
                .createQuery("from User")
                .list();
    }

    @Override
    public User findOne(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);

        return user;
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
