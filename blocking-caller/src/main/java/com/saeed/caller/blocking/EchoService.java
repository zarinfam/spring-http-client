package com.saeed.caller.blocking;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "/echo")
public interface EchoService {

    @GetExchange("/{message}")
    Echo echo(@PathVariable String message);

}
