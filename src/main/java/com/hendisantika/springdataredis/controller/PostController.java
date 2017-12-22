package com.hendisantika.springdataredis.controller;

import com.hendisantika.springdataredis.exception.PostNotFoundException;
import com.hendisantika.springdataredis.model.Post;
import com.hendisantika.springdataredis.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-data-redis
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/12/17
 * Time: 09.20
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/posts")
public class PostController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Cacheable(value = "post-single", key = "#id", unless = "#result.shares < 500")
    @GetMapping("/{id}")
    public Post getPostByID(@PathVariable String id) throws PostNotFoundException {
        log.info("get post with id {}", id);
        return postService.getPostByID(id);
    }

    @CachePut(value = "post-single", key = "#post.id")
    @PutMapping("/update")
    public Post updatePostByID(@RequestBody Post post) {
        log.info("update post with id {}", post.getId());
        postService.updatePost(post);
        return post;
    }

    @CacheEvict(value = "post-single", key = "#id")
    @DeleteMapping("/delete/{id}")
    public void deletePostByID(@PathVariable String id) {
        log.info("delete post with id {}", id);
        postService.deletePost(id);
    }

    @Cacheable(value = "post-top")
    @GetMapping("/top")
    public List<Post> getTopPosts() {
        return postService.getTopPosts();
    }

    @CacheEvict(value = "post-top")
    @GetMapping("/top/evict")
    public void evictTopPosts() {
        log.info("Evict post-top");
    }
}
