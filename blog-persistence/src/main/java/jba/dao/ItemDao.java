package jba.dao;

import jba.entity.Blog;
import jba.entity.Item;

import java.util.List;

public interface ItemDao {
    public List<Item> findByBlog(Blog blog/*, Pageable pageable*/);

    public void save(Item item);
}
