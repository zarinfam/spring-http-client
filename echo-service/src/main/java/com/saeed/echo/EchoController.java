package com.saeed.echo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {


    @GetMapping("/echo/{message}")
    public Echo echo(@PathVariable String message) {
        return new Echo("Echo:" + message);
    }

    @PostMapping("/echo")
    public Echo echo(@RequestBody Echo echo) {
        return new Echo("Echo:" + echo.message());
    }
}
