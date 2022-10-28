package com.example.Spring.boot.rest.api.with.mysql.controller;

import com.example.Spring.boot.rest.api.with.mysql.model.Post;
import com.example.Spring.boot.rest.api.with.mysql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/posts").toUriString());
        return ResponseEntity.created(uri).body(service.createPost(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts(){
        return ResponseEntity.ok().body(service.getPosts());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getPost(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getPostById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Post> getPostsByTitle(@PathVariable String title){
        return ResponseEntity.ok().body(service.getPostByTitle(title));
    }

    @GetMapping("/cat")
    public ResponseEntity<List<Post>> getPostsByCategory(@RequestParam String cat){
        return ResponseEntity.ok().body(service.getPostByCategory(cat));
    }

    @PatchMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/posts").toUriString());
        return ResponseEntity.created(uri).body(service.updatePost(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePost(@PathVariable Long id){
        return ResponseEntity.ok().body(service.deletePost(id));
    }
}
