package jba.dao.impl;

import jba.dao.RoleDao;
import jba.model.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Role role) {
        getCurrentSession().save(role);
    }

    @Override
    public Role findByName(String role) {
        Query query = getCurrentSession()
                .createQuery("from Role where name=?")
                .setParameter(0, role);
        List<Role> roles = query.list();
        if (roles.size() > 0) {
            return roles.get(0);
        } else {
            return null;
        }
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
