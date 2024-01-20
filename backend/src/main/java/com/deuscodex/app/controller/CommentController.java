package com.deuscodex.app.controller;

import com.deuscodex.app.dto.CommentDTO;
import com.deuscodex.app.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{commentId}")
    public ResponseEntity<?> getCommentById(@PathVariable Long commentId) {
        CommentDTO commentDTO = commentService.getCommentById(commentId);
        return (commentDTO != null) ? ResponseEntity.ok(commentDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        List<CommentDTO> comments = commentService.getAllComments();
        return (comments != null && !comments.isEmpty()) ? ResponseEntity.ok(comments) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@Valid @RequestBody CommentDTO commentDTO) {
        CommentDTO createdComment = commentService.createComment(commentDTO);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long commentId, @Valid @RequestBody CommentDTO commentDTO) {
        CommentDTO updatedComment = commentService.updateComment(commentId, commentDTO);
        return (updatedComment != null) ? ResponseEntity.ok(updatedComment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        boolean deleted = commentService.deleteComment(commentId);
        return (deleted) ? ResponseEntity.ok("Comment deleted successfully") : ResponseEntity.notFound().build();
    }
}
