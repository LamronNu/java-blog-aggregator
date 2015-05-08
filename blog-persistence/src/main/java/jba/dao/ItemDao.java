package jba.dao;

import jba.model.Blog;
import jba.model.Item;
import jba.model.PageRequest;
import org.hibernate.criterion.Order;

import java.util.List;

public interface ItemDao {
    //consts
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final String DEFAULT_SORT_FIELD = "publishedDate";
    public static final Order[] DEFAULT_SORT_ORDER = new Order[]{Order.desc(DEFAULT_SORT_FIELD)};


    public List<Item> findByBlog(Blog blog/*, Pageable pageable*/);

    public void save(Item item);

    Item findByBlogAndLink(Blog blog, String link);

    List<Item> findAll();

    List<Item> findAll(PageRequest pageRequest);
    List<Item> findAll(int pageNumber);

    int findCount();
}
