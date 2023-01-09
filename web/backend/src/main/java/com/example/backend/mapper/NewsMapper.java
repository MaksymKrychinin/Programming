package com.example.backend.mapper;

import com.example.backend.dto.NewsDto;
import com.example.backend.entity.News;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper {

    public NewsDto newsToDto(News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setMessage(news.getMessage());
        return newsDto;
    }
    public News dtoToNews(NewsDto newsDto) {
        News news = new News();
        news.setId(newsDto.getId());
        news.setMessage(newsDto.getMessage());
        return news;
    }
}
