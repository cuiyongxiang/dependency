package com.example.provider.controller;

import com.cuiyongxiang.commons.model.Book;
import com.cuiyongxiang.commons.model.User;
import com.example.provider.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody User  user) {

        userService.addUser(user);
        return "session";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(@RequestParam String name) {

        return "hello " + name + "!";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public Book hello2(@RequestHeader String name, @RequestHeader String author, @RequestHeader Integer price) throws UnsupportedEncodingException {
        Book book = new Book();
        book.setName(URLDecoder.decode(name,"UTF-8"));
        book.setAuthor(URLDecoder.decode(author,"UTF-8"));
        book.setPrice(price);
        System.out.println(book);
        return book;
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello3(@RequestBody Book book) {
        return "书名为：" + book.getName() + ";作者为：" + book.getAuthor();
    }





}
