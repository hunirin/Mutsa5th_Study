package com.example.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void articleRepositoryIsNotNull() {
        assertThat(articleRepository).isNotNull();
    }

    @Test
    public void createArticle() {
        // given
        Article article = new Article();
        article.setTitle("Hello!");
        article.setContent("TDD is hard but useful!");

        // when
        Article result = articleRepository.save(article);

        // then
        assertThat(result.getId()).isNotNull();
        assertEquals(result.getTitle(), "Hello!");
        assertEquals(result.getContent(), "TDD is hard but useful!");
    }
}
