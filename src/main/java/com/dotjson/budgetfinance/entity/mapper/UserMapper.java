package com.dotjson.budgetfinance.entity.mapper;

import com.dotjson.budgetfinance.entity.User;
import com.dotjson.budgetfinance.entity.request.UserRequest;
import com.dotjson.budgetfinance.entity.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "user.password", ignore = true)
    UserResponse userEntityToResponse(User user);

    User userRequestToEntity(UserRequest request);
}
