package jba.service;

import jba.entity.Blog;
import jba.entity.Item;
import jba.entity.Role;
import jba.entity.User;
import jba.repository.BlogRepository;
import jba.repository.ItemRepository;
import jba.repository.RoleRepository;
import jba.repository.UserRepository;
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
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_Admin");
        roleRepository.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("admin");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);

        Blog blogJava = new Blog();
        blogJava.setName("JavaVids");
        blogJava.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogJava.setUser(userAdmin);
        blogRepository.save(blogJava);

        Item item1 = new Item();
        item1.setBlog(blogJava);
        item1.setTitle("first");
        item1.setLink("http://www.javavids.com");
        item1.setPublishedDate(new Date());
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setBlog(blogJava);
        item2.setTitle("second");
        item2.setLink("http://www.javavids.com");
        item2.setPublishedDate(new Date());
        itemRepository.save(item2);


    }
}
