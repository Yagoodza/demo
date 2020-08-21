package com.yagudza.demo.controllers;
//
//import com.yagudza.demo.domain.Likes;
//import com.yagudza.demo.domain.News;
//import com.yagudza.demo.domain.User;
//import com.yagudza.demo.service.LikesService;
//import com.yagudza.demo.service.NewsService;
//import com.yagudza.demo.service.UserService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
public class LikesController {
//
//
//    private final LikesService likesService;
//    private final UserService userService;
//    private final NewsService newsService;
//
//    public LikesController(final LikesService likesService
//            , final UserService userService
//            , final NewsService newsService) {
//        this.likesService = likesService;
//        this.userService = userService;
//        this.newsService = newsService;
//    }
//
//    @PostMapping("/like")
//    public Likes likesAdd(@RequestParam(value = "user") Long userId
//            , @RequestParam(value = "news") Long newsId) {
//        User user = userService.findById(userId);
//        News news = newsService.findById(newsId).get();
//        Likes likes = Likes.builder()
//                .user(user)
//                .news(news)
//                .build();
//        news.setLikesCount(news.getLikesCount() + 1);
//        newsService.save(news);
//        return likesService.save(likes);
//    }
//
//    @GetMapping("/like/{id}")
//    public Iterable<Likes> showsNewsWithLike(@PathVariable(value = "id") Long id) {
//        return likesRepository.findByUser(userRepository.findById(id).get());
//    }
}
