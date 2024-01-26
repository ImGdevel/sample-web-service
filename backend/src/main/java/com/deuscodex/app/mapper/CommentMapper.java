package com.deuscodex.app.mapper;

import com.deuscodex.app.domain.Comment;
import com.deuscodex.app.dto.CommentDTO;

public class CommentMapper {

    private CommentMapper() {
        // 인스턴스 생성 방지
    }

    public static CommentDTO toDTO(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .member(MemberMapper.toDTO(comment.getMember()))
                .post(PostMapper.toDTO(comment.getPost()))
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public static Comment toEntity(CommentDTO commentDTO) {
        return Comment.builder()
                .id(commentDTO.getId())
                .member(MemberMapper.toEntity(commentDTO.getMember()))
                .post(PostMapper.toEntity(commentDTO.getPost()))
                .content(commentDTO.getContent())
                .build();
    }
}
