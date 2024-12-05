package com.bank.mobilewalletservice.mapper;

import com.bank.mobilewalletservice.model.document.User;
import com.bank.mobilewalletservice.model.dto.request.UserRequest;
import com.bank.mobilewalletservice.model.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDocument(UserRequest request);

    UserResponse toResponse(User user);
}
