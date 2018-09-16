package com.cuiyongxiang.consumer.service;

import com.cuiyongxiang.commons.model.Book;
import com.cuiyongxiang.commons.model.User;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback  implements UserService {


    @Override
    public String addUser(User user) {
        return null;
    }
    @Override
    public String hello() {
        return "hello error";
    }

    @Override
    public String hello(String name) {
        return "error " + name;
    }

    @Override
    public Book hello(String name, String author, Integer price) {
        Book book = new Book();
        book.setName("error");
        return book;
    }

    @Override
    public String hello(Book book) {
        return "error book";
    }
}
