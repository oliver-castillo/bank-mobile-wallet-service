package com.bank.mobilewalletservice.service;

import com.bank.mobilewalletservice.model.dto.request.UserRequest;
import com.bank.mobilewalletservice.model.dto.response.OperationResponse;
import com.bank.mobilewalletservice.model.dto.response.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<OperationResponse> save(UserRequest request);

    Mono<UserResponse> findById(String id);

    Flux<UserResponse> findAll();

    Mono<OperationResponse> update(String id, UserRequest request);

    Mono<OperationResponse> delete(String id);
}
