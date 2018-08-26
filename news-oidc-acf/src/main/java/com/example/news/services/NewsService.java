package com.example.news.services;

import com.example.news.models.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private List<News> storage;

    public List<News> getNews() {
        return storage;
    }

}
