package com.cuiyongxiang.consumer.controller;

import com.cuiyongxiang.commons.model.Book;
import com.cuiyongxiang.commons.model.User;
import com.cuiyongxiang.consumer.service.UserService;
import com.sun.deploy.net.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloController() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    @RequestMapping("/hello")
    public String hello() {
        return userService.hello();
    }


    @RequestMapping("/addUser")
    public String addUser() {
        User user = new User();
        user.setUserName("cuicui");
        user.setPhone("111222223333");
        user.setPassword("123456");
        return userService.addUser(user);
    }

    @RequestMapping("/hello1")
    public String hello1() {
        return userService.hello("张三");
    }

    @RequestMapping(value = "/hello2")
    public Book hello2() throws UnsupportedEncodingException {
        Book book = userService.hello(URLEncoder.encode("三国演义","UTF-8"), URLEncoder.encode("罗贯中","UTF-8"), 33);
        System.out.println(book);
        return book;
    }

    @RequestMapping("/hello3")
    public String hello3() {
        Book book = new Book();
        book.setName("红楼梦");
        book.setPrice(44);
        book.setAuthor("曹雪芹");
        return userService.hello(book);
    }



}
