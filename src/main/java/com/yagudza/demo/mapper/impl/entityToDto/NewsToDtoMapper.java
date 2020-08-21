package com.yagudza.demo.mapper.impl.entityToDto;

import com.yagudza.demo.domain.News;
import com.yagudza.demo.dto.dtoOut.NewsDtoOut;
import com.yagudza.demo.mapper.IMapper;
import org.springframework.stereotype.Service;

@Service
public class NewsToDtoMapper implements IMapper<News, NewsDtoOut> {

    @Override
    public NewsDtoOut map(News source) {
        if (source == null) {
            return null;
        }
        final var newsDto = new NewsDtoOut();
        newsDto.setId(source.getId());
        newsDto.setTitle(source.getTitle());
        newsDto.setAnons(source.getAnons());
        newsDto.setFullText(source.getFullText());
        newsDto.setPublicationDate(source.getPublicationDate());
        newsDto.setPublicationTime(source.getPublicationTime());
        newsDto.setLikesCount(source.getLikesCount());
        return newsDto;
    }
}