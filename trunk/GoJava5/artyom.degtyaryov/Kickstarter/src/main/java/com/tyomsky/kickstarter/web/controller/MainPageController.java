package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.service.CategoryService;
import com.tyomsky.kickstarter.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

    private QuoteService quoteService;
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("quote", quoteService.getRandomQuote());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "mainPage";
    }

    @Autowired
    public void setQuoteService(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

}