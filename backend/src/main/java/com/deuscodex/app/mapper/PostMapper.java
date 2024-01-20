package com.deuscodex.app.mapper;

import com.deuscodex.app.domain.Post;
import com.deuscodex.app.dto.PostDTO;

public class PostMapper {

    private PostMapper() {
        // 인스턴스 생성 방지
    }

    public static PostDTO toDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .member(MemberMapper.toDTO(post.getMember()))
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .views(post.getViews())
                .build();
    }

    public static Post toEntity(PostDTO postDTO) {
        return Post.builder()
                .id(postDTO.getId())
                .member(MemberMapper.toEntity(postDTO.getMember()))
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .createdAt(postDTO.getCreatedAt())
                .views(postDTO.getViews())
                .build();
    }
}
