package com.example.news.services;

import com.example.news.models.News;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NewsService {

    private List<News> storage = new ArrayList<News>();

    public List<News> getNews() {
        return storage;
    }

    public void addNews(News entry) {
        storage.add(entry);
    }

}
