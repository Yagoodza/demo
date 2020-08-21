package com.yagudza.demo.controllers;

import com.yagudza.demo.dto.dtoIn.NewsDtoIn;
import com.yagudza.demo.dto.dtoOut.NewsDtoOut;
import com.yagudza.demo.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
public class NewsController {

    final private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/addNews")
    public ResponseEntity<NewsDtoOut> addNews(@RequestBody NewsDtoIn newsDtoIn) {
        return ResponseEntity.ok(newsService.save(newsDtoIn));
    }

    @PutMapping("news/{id}/edit")
    public ResponseEntity<NewsDtoOut> newsPostUpdate(@PathVariable(value = "id") long id
            , @RequestBody NewsDtoIn newsDtoIn) {
        return ResponseEntity.ok(newsService.update(newsDtoIn, id));
    }


    /**
     * если ресурса нет, возвращает статус 204
     * если есть, удаляет, возвращает 200
     */
    @DeleteMapping("news/{id}")
    public ResponseEntity<?> newsPostRemove(@PathVariable(value = "id") long id) {
        if (!newsService.existsById(id)){
            return ResponseEntity.noContent().build();
        }
        newsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAllNews")
    public ResponseEntity<Iterable<NewsDtoOut>> findAllNews() {
        return ResponseEntity.ok(newsService.findAll());
    }

    /**
     * @return Новости за дату или пустой json или bad request
     */
    @GetMapping("/findByDate/{date}")
    public ResponseEntity<Iterable<NewsDtoOut>> findByDate(@PathVariable(value = "date") String date) {
        try {
            LocalDate publicationDate = LocalDate.parse(date);
            return ResponseEntity.ok(newsService.findByPublicationDate(publicationDate));
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}