package com.example.backend.controller;

import com.example.backend.dto.NewsDto;
import com.example.backend.service.NewsService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
@AllArgsConstructor
@CrossOrigin
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/getAll")
    public List<NewsDto> getAllGroups() {
        return newsService.getAllNews();
    }

    @PostMapping("/getById")
    public NewsDto getNewsById(@RequestBody NewsDto newsDto) {
        return newsService.getNewsById(newsDto.getId());
    }

    @PostMapping("/save")
    public NewsDto saveGroup(@Validated @RequestBody NewsDto newsDto) {
        return newsService.saveNews(newsDto);
    }

    @PostMapping("/update")
    public NewsDto updateGroup(@Validated @RequestBody NewsDto newsDto) {
        return newsService.updateNews(newsDto);
    }

    @PostMapping("/delete")
    public void deleteGroup(@RequestBody NewsDto newsDto) {
        newsService.deleteNewsById(newsDto.getId());
    }
}
