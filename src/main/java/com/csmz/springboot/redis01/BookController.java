package com.csmz.springboot.redis01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwudi
 * @date 2019/7/9 - 11:21
 */
@RestController
public class BookController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @GetMapping("/test1")
    public void test1() {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("name","1");
        String name = opsForValue.get("name");
        System.out.println(name);

        ValueOperations opsForValue1 = redisTemplate.opsForValue();
        Book book = new Book();
        book.setId(1);
        book.setName("红楼梦");
        book.setAuthor("曹雪芹");
        opsForValue1.set("book",book);
        Book book1 = (Book)opsForValue1.get("book");
        System.out.println(book1);
    }
}
