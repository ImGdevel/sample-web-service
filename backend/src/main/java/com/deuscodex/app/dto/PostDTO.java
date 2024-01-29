package com.deuscodex.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) // Lombok의 Accessors를 사용하여 chain 속성을 true로 설정
public class PostDTO {

    @Setter
    private Long id;

    @Setter
    private MemberDTO member;

    @Setter
    private String title;

    @Setter
    private String content;


    private int views;
}
