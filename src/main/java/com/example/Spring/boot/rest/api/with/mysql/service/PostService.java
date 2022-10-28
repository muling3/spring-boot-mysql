package com.example.Spring.boot.rest.api.with.mysql.service;

import com.example.Spring.boot.rest.api.with.mysql.model.Post;
import com.example.Spring.boot.rest.api.with.mysql.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PostService {
    @Autowired
    private PostsRepository repository;

    public List<Post> getPosts(){
        return repository.findAll();
    }

    public Object getPostById(Long id){
        if (repository.findById(id) != null)
            return repository.findById(id);
        return "{ \t\"message\": \"Not found\"\t}";
    }

    public Post getPostByTitle(String title){
        return repository.findByTitle(title);
    }

    public List<Post> getPostByCategory(String cat){
        return repository.findByCategory(cat);
    }

    public Post createPost(Post post){
        return repository.save(post);
    }

    public Post updatePost(Post post){
        Post p = repository.findById(post.getId()).orElse(null);
        p.setTitle(post.getTitle());
        p.setBody(post.getBody());
        p.setCategory(post.getCategory());

        return  p;
    }

    public Map<String, String> deletePost(Long id){
        repository.deleteById(id);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Post with id "+id+" deleted successfully");
        return map;
    }
}
