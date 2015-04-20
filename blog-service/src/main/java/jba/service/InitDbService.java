package jba.service;

import jba.dao.BlogDao;
import jba.dao.ItemDao;
import jba.dao.RoleDao;
import jba.dao.UserDao;
import jba.entity.Blog;
import jba.entity.Item;
import jba.entity.Role;
import jba.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class InitDbService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BlogDao blogDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private RoleDao roleDao;

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleDao.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_Admin");
        roleDao.save(roleAdmin);

        //user admin
        User userAdmin = new User();
        userAdmin.setName("admin");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userDao.save(userAdmin);

        Blog blogJava = new Blog();
        blogJava.setName("JavaVids");
        blogJava.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogJava.setUser(userAdmin);
        blogDao.save(blogJava);

        Item item1 = new Item();
        item1.setBlog(blogJava);
        item1.setTitle("first");
        item1.setLink("http://www.javavids.com");
        item1.setPublishedDate(new Date());
        itemDao.save(item1);

        Item item2 = new Item();
        item2.setBlog(blogJava);
        item2.setTitle("second");
        item2.setLink("http://www.javavids.com");
        item2.setPublishedDate(new Date());
        itemDao.save(item2);

        //user test
        User userTest = new User();
        userTest.setName("test");
        roles = new ArrayList<Role>();
        roles.add(roleUser);
        userTest.setRoles(roles);
        userDao.save(userTest);

        blogJava = new Blog();
        blogJava.setName("web-service blog");
        blogJava.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogJava.setUser(userTest);
        blogDao.save(blogJava);

        item1 = new Item();
        item1.setBlog(blogJava);
        item1.setTitle("first item");
        item1.setLink("http://www.javavids.com");
        item1.setPublishedDate(new Date());
        itemDao.save(item1);

        item2 = new Item();
        item2.setBlog(blogJava);
        item2.setTitle("second");
        item2.setLink("http://www.javavids.com");
        item2.setPublishedDate(new Date());
        itemDao.save(item2);

        item2 = new Item();
        item2.setBlog(blogJava);
        item2.setTitle("third");
        item2.setLink("http://www.javavids.com");
        item2.setPublishedDate(new Date());
        itemDao.save(item2);

    }
}
