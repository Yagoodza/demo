package com.yagudza.demo.repository;

import com.yagudza.demo.domain.News;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface NewsRepository extends CrudRepository<News, Long> {

    /**
     * Find news by date
     */
    List<News> findByPublicationDate(LocalDate publicationDate);
}