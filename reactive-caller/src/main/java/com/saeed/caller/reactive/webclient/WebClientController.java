package com.saeed.caller.reactive.webclient;

import com.saeed.caller.reactive.Echo;
import com.saeed.caller.reactive.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wc")
public class WebClientController {

    private final WebClient webClient;
    private final EchoService echoService;

    public WebClientController(WebClient webClient, EchoService echoService) {
        this.webClient = webClient;
        this.echoService = echoService;
    }

    @GetMapping("/echo/{message}")
    public Mono<Echo> echo(@PathVariable String message) {
        return webClient
                .get()
                .uri("/echo/" + message)
                .retrieve()
                .bodyToMono(Echo.class);
    }

    @GetMapping("/interface/echo/{message}")
    public Mono<Echo> echoInterface(@PathVariable String message) {
        return echoService.echo(message);
    }

}
