package jba.service;

import jba.Exception.RssException;
import jba.model.Item;

import java.io.File;
import java.util.List;

public interface RssService {
    public List<Item> getItems(File file) throws RssException;

    public List<Item> getItems(String url) throws RssException;
}
