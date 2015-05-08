package jba.controller;

import jba.dao.ItemDao;
import jba.model.Item;
import jba.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/index")
    public String index(Model model) {
        return showPage(model, 1);
//        List<Item> items = itemService.getItems();
//        int count = itemService.getItemsCount();
//        int pages = (int) Math.floor(count / ItemDao.DEFAULT_PAGE_SIZE);
//        model.addAttribute("items", items);
//        model.addAttribute("pages", pages);
//        model.addAttribute("pageSize", ItemDao.DEFAULT_PAGE_SIZE);
//        model.addAttribute("currentPage", 1);
//        return "index";
    }

    @RequestMapping("/page/{pageNumber}")
    public String showSelectedPage(Model model, @PathVariable int pageNumber) {
        return showPage(model, pageNumber);
    }

    private String showPage(Model model, int pageNumber) {
        List<Item> items = itemService.getItems(pageNumber);
        int count = itemService.getItemsCount();
        int pages = (int) Math.floor(count / ItemDao.DEFAULT_PAGE_SIZE);
        model.addAttribute("items", items);
        model.addAttribute("pages", pages);
        model.addAttribute("pageSize", ItemDao.DEFAULT_PAGE_SIZE);
        model.addAttribute("currentPage", pageNumber);
        return "index";
    }

}
