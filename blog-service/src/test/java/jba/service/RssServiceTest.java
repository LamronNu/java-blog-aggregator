package jba.service;

import jba.Exception.RssException;
import jba.model.Item;
import jba.service.impl.RssServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RssServiceTest {

    private RssService rssService;

    @Before
    public void setUp() throws Exception {
        rssService = new RssServiceImpl();
    }

    @Test
    public void testGetItemsFile() throws RssException {
        List<Item> items = rssService.getItems(new File("test-rss/javavids.xml"));
        assertEquals(10, items.size());
        Item firstItem = items.get(0);
        assertEquals("How to generate web.xml in Eclipse", firstItem.getTitle());
        assertEquals("23 03 2014 10:01:34", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
    }

}