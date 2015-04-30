package jba.dao;

import jba.model.Blog;
import jba.model.Item;

import java.util.List;

public interface ItemDao {
    public List<Item> findByBlog(Blog blog/*, Pageable pageable*/);
    public void save(Item item);

    Item findByBlogAndLink(Blog blog, String link);
}
