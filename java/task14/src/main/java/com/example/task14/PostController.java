package com.example.task14;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private List<Post> posts = new ArrayList<>();

    @GetMapping
    public List<Post> getAllPosts() {
        return posts;
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        post.setCreationDate(LocalDateTime.now());
        posts.add(post);
        return post;
    }

    @DeleteMapping("/{index}")
    public void deletePost(@PathVariable int index) {
        if (index >= 0 && index < posts.size()) {
            posts.remove(index);
        }
    }
}