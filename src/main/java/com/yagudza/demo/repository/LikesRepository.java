package com.yagudza.demo.repository;

import com.yagudza.demo.domain.Likes;
import com.yagudza.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikesRepository extends CrudRepository<Likes, Long> {

    List<Likes> findByUser(User user);

    void deleteByUser_Id(Long id);
}