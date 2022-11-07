package com.jojoldu.book.springboot.web;
import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController     // 컨트롤러를 JSON을 반환하는 컨트롤러로 변경
public class HelloController {

    @GetMapping("/hello")   //HTTP Method인 Get의 요청을 받을 수 있는 api 제작
    public String hello() {
        return "hello";     // 문자열 /hello로 요청이 오면 hello를 반환하는 기능
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
