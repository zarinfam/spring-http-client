package com.saeed.caller.blocking.resttemplate;

import com.saeed.caller.blocking.Echo;
import com.saeed.caller.blocking.EchoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rt")
public class RestTemplateController {

    private final RestTemplate restTemplate;
    private final EchoService echoService;

    public RestTemplateController(RestTemplate restTemplate, @Qualifier("rt") EchoService echoService) {
        this.restTemplate = restTemplate;
        this.echoService = echoService;
    }

    @GetMapping("/echo/{message}")
    public Echo echo(@PathVariable String message) {
        return restTemplate.getForObject("http://localhost:8080/echo/" + message, Echo.class);
    }

    @GetMapping("/interface/echo/{message}")
    public Echo echoInterface(@PathVariable String message) {
        return echoService.echo(message);
    }

}
