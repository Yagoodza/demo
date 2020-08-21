package com.yagudza.demo.service.impl;

import com.yagudza.demo.domain.News;
import com.yagudza.demo.dto.dtoIn.NewsDtoIn;
import com.yagudza.demo.dto.dtoOut.NewsDtoOut;
import com.yagudza.demo.mapper.impl.dtoToEntity.DtoToNewsMapper;
import com.yagudza.demo.mapper.impl.entityToDto.NewsToDtoMapper;
import com.yagudza.demo.repository.NewsRepository;
import com.yagudza.demo.service.NewsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final NewsToDtoMapper newsToDtoMapper;
    private final DtoToNewsMapper dtoToNewsMapper;

    public NewsServiceImpl(NewsRepository newsRepository
            , NewsToDtoMapper newsToDtoMapper
            , DtoToNewsMapper dtoToNewsMapper) {
        this.newsRepository = newsRepository;
        this.newsToDtoMapper = newsToDtoMapper;
        this.dtoToNewsMapper = dtoToNewsMapper;
    }

    @Override
    public NewsDtoOut save(NewsDtoIn newsDtoIn) {
        News news = dtoToNewsMapper.map(newsDtoIn);
        news.setPublicationDate(LocalDate.now());
        news.setPublicationTime(LocalTime.now());
        news.setLikesCount(0L);
        return newsToDtoMapper.map(newsRepository.save(news));
    }

    @Override
    public NewsDtoOut update (NewsDtoIn newsDtoIn, long id){
        News updated = newsRepository.findById(id).orElseThrow();
        News news = dtoToNewsMapper.map(newsDtoIn);
        updated.setTitle(news.getTitle());
        updated.setAnons(news.getAnons());
        updated.setFullText(news.getFullText());
        return newsToDtoMapper.map(newsRepository.save(updated));
    }

    @Override
    public Iterable<NewsDtoOut> findAll() {
        final Iterable<News> news = newsRepository.findAll();
        return newsToDtoMapper.map(news);
    }

    @Override
    public Iterable<NewsDtoOut> findByPublicationDate(LocalDate publicationDate) {
        return newsToDtoMapper.map(newsRepository.findByPublicationDate(publicationDate));
    }

    @Override
    public void deleteById(long id){
        newsRepository.deleteById(id);
    }

    @Override
    public NewsDtoOut findById(long id) {
        return newsToDtoMapper.map(newsRepository.findById(id).orElseThrow());
    }

    @Override
    public boolean existsById(long id){
       return newsRepository.existsById(id);
    }
}
