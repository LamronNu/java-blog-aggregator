package jba.dao;

import jba.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> findAll() {
        return (List<User>) sessionFactory.getCurrentSession()
                .createQuery("from user")
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
