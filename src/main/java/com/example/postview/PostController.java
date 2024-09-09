package com.example.postview;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PostController {

    @GetMapping("/posts")
    public List<Post> getPosts() {
        // 예시로 하드코딩된 데이터를 반환
        return Arrays.asList(
                new Post("Post 1", "Content 1"),
                new Post("Post 2", "Content 2")
        );
    }
}

class Post {
    private String title;
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter, Setter
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
