package com.cuiyongxiang.consumer.service;


import com.cuiyongxiang.commons.model.Book;
import com.cuiyongxiang.commons.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "hello-service" ,fallback = HelloServiceFallback.class)
public interface UserService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    String addUser(@RequestBody User user);

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    Book hello(@RequestHeader("name") String name, @RequestHeader("author") String author, @RequestHeader("price") Integer price);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody Book book);

}
