package cn.liuxiaokang.authresource.web;

import cn.liuxiaokang.authresource.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("/")
    public Message home() {
        return new Message("Hello World");
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
