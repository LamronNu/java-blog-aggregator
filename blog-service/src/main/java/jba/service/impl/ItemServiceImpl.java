package jba.service.impl;

import jba.dao.ItemDao;
import jba.model.Item;
import jba.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getItems() {
        return itemDao.findAll();
        // /*new PageRequest(0, 20, Direction.DESC, "publishedDate")*/).getContent();
    }

    @Override
    public int getItemsCount() {
        return itemDao.findCount();
    }

    @Override
    public List<Item> getItems(int pageNumber) {
        return itemDao.findAll(pageNumber);
    }
}
