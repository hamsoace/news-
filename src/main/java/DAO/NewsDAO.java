package DAO;

import models.News;

import java.util.List;

public interface NewsDAO {
    void add(News news);

    News findById(int id);
    List<News>getAllNews();

    void updateNews(int id, String newsName, String content, int departmentId);

    void deleteById(int id);

    void clearAll();
}
