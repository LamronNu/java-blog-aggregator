package jba.dao;

import jba.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }
}
