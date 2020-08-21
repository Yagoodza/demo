package com.yagudza.demo.service;

import com.yagudza.demo.domain.News;
import com.yagudza.demo.dto.dtoIn.NewsDtoIn;
import com.yagudza.demo.dto.dtoIn.UserDtoIn;
import com.yagudza.demo.dto.dtoOut.NewsDtoOut;
import com.yagudza.demo.dto.dtoOut.UserDtoOut;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface NewsService {

    NewsDtoOut save (NewsDtoIn newsDtoIn);

    NewsDtoOut update (NewsDtoIn newsDtoIn, long id);

    Iterable<NewsDtoOut> findAll();

    Iterable<NewsDtoOut> findByPublicationDate(LocalDate publicationDate);

    void deleteById(long id);

    NewsDtoOut findById(long id);

    boolean existsById(long id);
}
