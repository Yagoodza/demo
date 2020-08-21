package com.yagudza.demo.mapper.impl.dtoToEntity;

import com.yagudza.demo.domain.News;
import com.yagudza.demo.dto.dtoIn.NewsDtoIn;
import com.yagudza.demo.mapper.IMapper;
import org.springframework.stereotype.Service;

@Service
public class DtoToNewsMapper implements IMapper<NewsDtoIn, News> {
    @Override
    public News map(NewsDtoIn source) {
        if (source == null) {
            return null;
        }
        final var news = new News();
        news.setTitle(source.getTitle());
        news.setAnons(source.getAnons());
        news.setFullText(source.getFullText());
        return news;
    }
}
