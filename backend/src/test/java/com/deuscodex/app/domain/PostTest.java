package com.deuscodex.app.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    @DisplayName("Test Post Create")
    void createPostTest(){
        System.out.println("테스트 시작____________________");
        Post post =
                Post.builder().build();


        assertEquals(post.getViews(), 0);
    }
    @Test
    void getId() {

    }

    @Test
    void getMember() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void getContent() {
    }

    @Test
    void getViews() {
    }

    @Test
    void setId() {
    }

    @Test
    void setMember() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setContent() {
    }

    @Test
    void setViews() {
    }
}
