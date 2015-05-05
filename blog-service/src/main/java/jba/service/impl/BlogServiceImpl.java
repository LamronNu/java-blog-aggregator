package jba.service.impl;

import jba.Exception.RssException;
import jba.dao.BlogDao;
import jba.dao.ItemDao;
import jba.dao.UserDao;
import jba.model.Blog;
import jba.model.Item;
import jba.model.User;
import jba.service.BlogService;
import jba.service.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private RssService rssService;

    public void saveItems(Blog blog) {
        try {
            List<Item> items = rssService.getItems(blog.getUrl());
            for (Item item : items) {
                Item savedItem = itemDao.findByBlogAndLink(blog, item.getLink());
                if (savedItem == null) {
                    item.setBlog(blog);
                    itemDao.save(item);
                }
            }
        } catch (RssException e) {
            e.printStackTrace();//http://feeds.feedburner.com/javavids?format=xml
        }
    }

    // 1 hour = 60 seconds * 60 minutes * 1000
    @Scheduled(fixedDelay = 3600000)
    public void reloadBlogs() {
        List<Blog> blogs = blogDao.findAll();
        for (Blog blog : blogs) {
            saveItems(blog);
        }
    }

    @Override
    public void save(Blog blog, String username) {
        User user = userDao.findByUserName(username);
        blog.setUser(user);
        blogDao.save(blog);
        saveItems(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogDao.findById(id);
    }

    @Override
    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogDao.delete(blog);
    }
}
