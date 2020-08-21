package com.yagudza.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false, length = 45)
    private String title;
    @Column(name = "anons", nullable = false, length = 100)
    private String anons;
    @Column(name = "full_text", nullable = false, length = 2200)
    private String fullText;
    @Column(name = "publication_date", nullable = false)
    LocalDate publicationDate;
    @Column(name = "publication_time", nullable = false)
    LocalTime publicationTime;
    @Column(name = "likes_count")
    private Long likesCount;

        @JsonIgnore
//    @OneToMany(mappedBy = "news", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "news")
    private Set<Likes> likesSet;

}