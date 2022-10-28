package com.example.Spring.boot.rest.api.with.mysql.repository;

import com.example.Spring.boot.rest.api.with.mysql.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
    List<Post> findByCategory(String cat);
}
