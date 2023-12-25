package com.saeed.caller.reactive;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange(url = "/echo")
public interface EchoService {

    @GetExchange("/{message}")
    Mono<Echo> echo(@PathVariable String message);

}
