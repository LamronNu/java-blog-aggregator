package jba.service;

import jba.dao.BlogDao;
import jba.dao.ItemDao;
import jba.dao.RoleDao;
import jba.dao.UserDao;
import jba.model.Blog;
import jba.model.Role;
import jba.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
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
        //check on existing db data

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (roleDao.findByName("ROLE_ADMIN") == null) {

            Role roleUser = new Role();
            roleUser.setName("ROLE_USER");
            roleDao.save(roleUser);

            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roleDao.save(roleAdmin);
        }
        if (userDao.findByUserName("admin") == null) {
            //user admin
            User userAdmin = new User();
            userAdmin.setName("admin");
            userAdmin.setPassword(encoder.encode("admin"));
            userAdmin.setEnabled(true);
            List<Role> roles = new ArrayList<Role>();
            roles.add(roleDao.findByName("ROLE_ADMIN"));
            roles.add(roleDao.findByName("ROLE_USER"));
            userAdmin.setRoles(roles);
            userDao.save(userAdmin);

            //blog Java
            Blog blogJava = new Blog();
            blogJava.setName("JavaVids");
            blogJava.setUrl("http://feeds.feedburner.com/javavids?format=xml");
            blogJava.setUser(userAdmin);
            blogDao.save(blogJava);

            //eclipse blog
            blogJava = new Blog();
            blogJava.setName("Eclipse blog");
            blogJava.setUrl("http://eclipsesource.com/blogs/author/irbull/feed/");
            blogJava.setUser(userAdmin);
            blogDao.save(blogJava);

            //Java world core blog
            blogJava = new Blog();
            blogJava.setName("Java world core");
            blogJava.setUrl("http://www.javaworld.com/category/core-java/index.rss");
            blogJava.setUser(userAdmin);
            blogDao.save(blogJava);

            //
            blogJava = new Blog();
            blogJava.setName("Gosia blog");
            blogJava.setUrl("http://eclipsesource.com/blogs/author/gosia/feed/");
            blogJava.setUser(userAdmin);
            blogDao.save(blogJava);

            //
            blogJava = new Blog();
            blogJava.setName("jeick blog");
            blogJava.setUrl("http://eclipsesource.com/blogs/author/jeick/feed/");
            blogJava.setUser(userAdmin);
            blogDao.save(blogJava);
        }
//        Item item1 = new Item();
//        item1.setBlog(blogJava);
//        item1.setTitle("first");
//        item1.setLink("http://www.javavids.com");
//        item1.setPublishedDate(new Date());
//        itemDao.save(item1);
//
//        Item item2 = new Item();
//        item2.setBlog(blogJava);
//        item2.setTitle("second");
//        item2.setLink("http://www.javavids.com");
//        item2.setPublishedDate(new Date());
//        itemDao.save(item2);

        //user test
        if (userDao.findByUserName("test") == null) {
            User userTest = new User();
            userTest.setName("user");
            userTest.setPassword(encoder.encode("user"));
            userTest.setEnabled(true);
            List<Role> roles = new ArrayList<Role>();
            roles.add(roleDao.findByName("ROLE_USER"));
            userTest.setRoles(roles);
            userDao.save(userTest);

            //tomcat blog
            Blog blogJava = new Blog();
            blogJava.setName("Tomcat expert");
            blogJava.setUrl("http://www.tomcatexpert.com/blog/feed");
            blogJava.setUser(userTest);
            blogDao.save(blogJava);
        }
//        item1 = new Item();
//        item1.setBlog(blogJava);
//        item1.setTitle("first item");
//        item1.setLink("http://www.javavids.com");
//        item1.setPublishedDate(new Date());
//        itemDao.save(item1);
//
//        item2 = new Item();
//        item2.setBlog(blogJava);
//        item2.setTitle("second item");
//        item2.setLink("http://www.javavids.com");
//        item2.setPublishedDate(new Date());
//        itemDao.save(item2);
//
//        item2 = new Item();
//        item2.setBlog(blogJava);
//        item2.setTitle("third item");
//        item2.setLink("http://www.javavids.com");
//        item2.setPublishedDate(new Date());
//        itemDao.save(item2);

    }
}
