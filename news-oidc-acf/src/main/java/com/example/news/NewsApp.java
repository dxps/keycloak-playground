package com.example.news;

import com.example.news.models.News;
import com.example.news.services.NewsService;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;


@SpringBootApplication
public class NewsApp
		implements ApplicationContextAware, ApplicationListener<ApplicationReadyEvent> {

	private ApplicationContext appCtx;

	public static void main(String[] args) {
		SpringApplication.run(NewsApp.class, args);
	}


	public void setApplicationContext(ApplicationContext appCtx) throws BeansException {
		this.appCtx = appCtx;
	}

	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println(">>> NewsApp: Startup complete.");
		System.out.println(">>> NewsApp: Populating some news ...");
		NewsService newsService = appCtx.getBean(com.example.news.services.NewsService.class);
		newsService.addNews(new News("First News", "Detailed information about it ..."));
		newsService.addNews(new News("Second Entry", "Content of the second news entry ..."));
	}

}
