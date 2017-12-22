package com.hendisantika.springdataredis.service;

import com.hendisantika.springdataredis.exception.PostNotFoundException;
import com.hendisantika.springdataredis.model.Author;
import com.hendisantika.springdataredis.model.Post;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-data-redis
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/12/17
 * Time: 09.16
 * To change this template use File | Settings | File Templates.
 */

@Service
public class PostService {
    private List<Post> posts;

    @PostConstruct
    public void init() {
        posts = new ArrayList<>();
        posts.add(new Post("IDX001", "Cyberpunk is near", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 555, new Author("Anna")));
        posts.add(new Post("IDX002", "Welcome aboard of the hype train", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Josh")));
        posts.add(new Post("IDX003", "How to improve programming skills ", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 555, new Author("Kobe")));
        posts.add(new Post("IDX004", "Top exercises for IT people", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Leo")));
        posts.add(new Post("IDX005", "Case study of 75 years project", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Tom")));
        posts.add(new Post("IDX006", "Machine Learning", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 255, new Author("Alexa")));
        posts.add(new Post("IDX007", "Memory leaks, how to find them ", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 55, new Author("Frank")));
        posts.add(new Post("IDX008", "Robots builds robots", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 155, new Author("Milagros")));
        posts.add(new Post("IDX009", "Quantum algorithms, from the scratch", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 455, new Author("Sarah")));
        posts.add(new Post("IDX010", "Coding, coding, coding", "Description", "https://random-cdn.posts/images/xvn84934fnls.jpg", 255, new Author("Adam")));
    }

    public void updatePost(Post post) {
        posts = posts.stream().filter(p -> p.getId() != post.getId()).collect(Collectors.toList());
        posts.add(post);
    }

    public void deletePost(String postID) {
        posts = posts.stream().filter(p -> !p.getId().equals(postID)).collect(Collectors.toList());
    }

    public List<Post> getAllPost() {
        List<Post> result = posts.stream()                // convert list to stream
                .collect(Collectors.toList());            // collect the output and convert streams to a List

        return result;                //output : spring, node

    }


    /**
     * Load post content from DB *Long running method
     */
    public Post getPostByID(String postID) throws PostNotFoundException {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return posts.stream()
                .filter(p -> p.getId().equals(postID))
                .findFirst()
                .orElseThrow(() -> new PostNotFoundException("Cannot find post with id:" + postID));
    }


    /**
     * Load top ten posts from DB *Long running method
     */
    public List<Post> getTopPosts() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
