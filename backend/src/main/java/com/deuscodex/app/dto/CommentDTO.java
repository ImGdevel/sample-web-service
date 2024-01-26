package com.deuscodex.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long id;
    private MemberDTO member;
    private PostDTO post;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
