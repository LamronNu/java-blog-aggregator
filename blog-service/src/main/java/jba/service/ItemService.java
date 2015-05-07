package jba.service;

import jba.model.Item;

import java.util.List;

public interface ItemService {

    public List<Item> getItems();

    int getItemsCount();

    List<Item> getItems(int pageNumber);
}
