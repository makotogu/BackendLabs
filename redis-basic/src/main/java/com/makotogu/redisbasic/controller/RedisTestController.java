package com.makotogu.redisbasic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/{key}/{value}")
    public String stringTest(@PathVariable String key,
                             @PathVariable String value) {
        redisTemplate.opsForValue().append(key, value);
        return "aaaa";
    }

    @GetMapping("/get/value/{key}")
    public Object getString(@PathVariable String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @PutMapping("/del/{key}")
    public String delString(@PathVariable String key) {
        redisTemplate.delete(key);
        return "del done";
    }
}
