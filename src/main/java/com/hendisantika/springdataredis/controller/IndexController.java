package com.hendisantika.springdataredis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-data-redis
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/12/17
 * Time: 09.27
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping
    String getIndex() {
        return "Bismillah ! " + new Date();
    }
}
