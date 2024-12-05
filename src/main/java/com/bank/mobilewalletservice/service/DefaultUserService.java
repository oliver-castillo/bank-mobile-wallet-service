package com.bank.mobilewalletservice.service;

import com.bank.mobilewalletservice.mapper.UserMapper;
import com.bank.mobilewalletservice.model.document.User;
import com.bank.mobilewalletservice.model.dto.request.UserRequest;
import com.bank.mobilewalletservice.model.dto.response.OperationResponse;
import com.bank.mobilewalletservice.model.dto.response.UserResponse;
import com.bank.mobilewalletservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class DefaultUserService implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public Mono<OperationResponse> save(UserRequest request) {
        return repository.save(mapper.toDocument(request))
                .map(user -> new OperationResponse("Se realizó el registro exitosamente", 200));
    }

    @Override
    public Mono<UserResponse> findById(String id) {
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    @Override
    public Flux<UserResponse> findAll() {
        return repository.findAll()
                .map(mapper::toResponse);
    }

    @Override
    public Mono<OperationResponse> update(String id, UserRequest request) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Usuario no encontrado")))
                .map(user -> {
                    User userToUpdate = mapper.toDocument(request);
                    userToUpdate.setId(id);
                    return repository.save(userToUpdate);
                })
                .map(user -> new OperationResponse("Se actualizó el usuario exitosamente", 200));
    }

    @Override
    public Mono<OperationResponse> delete(String id) {
        return repository.deleteById(id)
                .then(Mono.fromCallable(() -> new OperationResponse("Se eliminó el usuario exitosamente", 200)));
    }
}
