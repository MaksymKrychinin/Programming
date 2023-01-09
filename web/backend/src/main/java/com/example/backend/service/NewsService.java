package com.example.backend.service;

import com.example.backend.dto.NewsDto;
import java.util.List;

public interface NewsService {

    List<NewsDto> getAllNews();

    NewsDto getNewsById(Long newsId);

    NewsDto saveNews(NewsDto groupDto);

    NewsDto updateNews(NewsDto groupDto);

    void deleteNewsById(Long newsId);
}
