package com.deuscodex.app.repository;

import com.deuscodex.app.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
