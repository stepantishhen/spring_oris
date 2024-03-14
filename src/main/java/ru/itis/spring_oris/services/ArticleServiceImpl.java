package ru.itis.spring_oris.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spring_oris.dto.ArticleDto;
import ru.itis.spring_oris.dto.ArticleForm;
import ru.itis.spring_oris.models.Article;
import ru.itis.spring_oris.models.User;
import ru.itis.spring_oris.repositores.ArticleRepository;
import ru.itis.spring_oris.repositores.UsersRepository;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public ArticleDto addArticle(Long userId, ArticleForm articleForm) {
        User user = usersRepository.getOne(userId);

        Article article = Article.builder()
                .author(user)
                .type(articleForm.getType())
                .text(articleForm.getText())
                .name(articleForm.getName())
                .build();

        articleRepository.save(article);
        return ArticleDto.from(article);
    }

    @Override
    public List<ArticleDto> getByUser(Long id){
        User user = usersRepository.getOne(id);
        List<Article> articleList = user.getCreatedArticles();
        return ArticleDto.articleList(articleList);
    }

    @Override
    public ArticleDto like(Long userId, Long articleId) {
        User user = usersRepository.getOne(userId);
        Article article = articleRepository.getOne(articleId);
        if(articleRepository.existsByArticleIdAndLikesContaining(articleId, user)) {
            article.getLikes().remove(user);
        }
        else {
            article.getLikes().add(user);
        }
        articleRepository.save(article);
        return ArticleDto.from(article);

    }
}