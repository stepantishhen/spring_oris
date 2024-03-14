package ru.itis.spring_oris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.spring_oris.dto.ArticleDto;
import ru.itis.spring_oris.dto.ArticleForm;
import ru.itis.spring_oris.services.ArticleService;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping("/users/{user-id}/articles")
    @ResponseBody
    public ArticleDto addArticle(@PathVariable("user-id") String userId,
                                 @RequestBody ArticleForm articleForm) {
        Long userIdLong = Long.parseLong(userId);
        return articleService.addArticle(userIdLong, articleForm);
    }
    // localhost:8080/users/1/articles
    @GetMapping("/users/{user-id}/articles")
    public String getArticlesOfUser(@PathVariable("user-id") Long userId, Model model) {
        model.addAttribute("articles", articleService.getByUser(userId));
        return "article_page";
    }
}