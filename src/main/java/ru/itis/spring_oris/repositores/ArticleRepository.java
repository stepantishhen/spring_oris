package ru.itis.spring_oris.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.spring_oris.models.Article;
import ru.itis.spring_oris.models.User;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    boolean existsByArticleIdAndLikesContaining(Long articleId, User user);
}