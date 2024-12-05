package com.bank.mobilewalletservice.controller;

import com.bank.mobilewalletservice.model.dto.request.UserRequest;
import com.bank.mobilewalletservice.model.dto.response.OperationResponse;
import com.bank.mobilewalletservice.model.dto.response.UserResponse;
import com.bank.mobilewalletservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    public Mono<OperationResponse> save(@RequestBody @Valid UserRequest request) {
        return userService.save(request);
    }

    @GetMapping(value = "/{id}")
    public Mono<UserResponse> findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @GetMapping
    public Flux<UserResponse> findAll() {
        return userService.findAll();
    }

    @PutMapping(value = "/{id}")
    public Mono<OperationResponse> update(@PathVariable String id, @RequestBody @Valid UserRequest request) {
        return userService.update(id, request);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<OperationResponse> delete(@PathVariable String id) {
        return userService.delete(id);
    }
}
