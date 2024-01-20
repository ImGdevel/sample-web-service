package com.deuscodex.app.controller;

import com.deuscodex.app.dto.PostDTO;
import com.deuscodex.app.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Long postId) {
        PostDTO postDTO = postService.getPostById(postId);
        return (postDTO != null) ? ResponseEntity.ok(postDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postService.getAllPosts();
        return (posts != null && !posts.isEmpty()) ? ResponseEntity.ok(posts) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO) {
        PostDTO createdPost = postService.createPost(postDTO);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long postId, @Valid @RequestBody PostDTO postDTO) {
        PostDTO updatedPost = postService.updatePost(postId, postDTO);
        return (updatedPost != null) ? ResponseEntity.ok(updatedPost) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        boolean deleted = postService.deletePost(postId);
        return (deleted) ? ResponseEntity.ok("Post deleted successfully") : ResponseEntity.notFound().build();
    }
}
