package com.deuscodex.app.service;

import com.deuscodex.app.dto.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO getPostById(Long postId);

    List<PostDTO> getAllPosts();

    PostDTO createPost(PostDTO postDTO);

    PostDTO updatePost(Long postId, PostDTO postDTO);

    boolean deletePost(Long postId);
}
