package com.saeed.caller.blocking.webclient;

import com.saeed.caller.blocking.Echo;
import com.saeed.caller.blocking.EchoService;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public WebClientController(WebClient webClient, @Qualifier("wc") EchoService echoService) {
        this.webClient = webClient;
        this.echoService = echoService;
    }

    @GetMapping("/echo/{message}")
    public Echo echo(@PathVariable String message) {
        return webClient
                .get()
                .uri("/echo/" + message)
                .retrieve()
                .bodyToMono(Echo.class)
                .block();
    }

    @GetMapping("/interface/echo/{message}")
    public Echo echoInterface(@PathVariable String message) {
        return echoService.echo(message);
    }

}
