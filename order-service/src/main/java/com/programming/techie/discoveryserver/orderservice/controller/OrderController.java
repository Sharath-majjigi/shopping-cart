package com.programming.techie.discoveryserver.orderservice.controller;

import com.programming.techie.discoveryserver.orderservice.dto.OrderRequest;
import com.programming.techie.discoveryserver.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory",fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        String res=orderService.placeOrder(orderRequest);
        return CompletableFuture.supplyAsync(()->res);
    }

    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest,RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()->"Sorry its not you its us :( , please order some time later !");
    }
}
