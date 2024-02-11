package com.deuscodex.app.service;

import com.deuscodex.app.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    CommentDTO getCommentById(Long commentId);

    List<CommentDTO> getAllComments();

    CommentDTO createComment(CommentDTO commentDTO);

    CommentDTO updateComment(Long commentId, CommentDTO commentDTO);

    boolean deleteComment(Long commentId);
}
