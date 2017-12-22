package com.hendisantika.springdataredis.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-data-redis
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/12/17
 * Time: 09.17
 * To change this template use File | Settings | File Templates.
 */
public class PostNotFoundException extends Exception {
    public PostNotFoundException(String message) {
        super(message);
    }
}
