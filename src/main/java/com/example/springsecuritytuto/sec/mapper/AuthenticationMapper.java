package com.example.springsecuritytuto.sec.mapper;

import com.example.springsecuritytuto.sec.config.EntityMapper;
import com.example.springsecuritytuto.sec.dto.response.AuthenticationResponse;
import com.example.springsecuritytuto.sec.entities.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface AuthenticationMapper extends EntityMapper<AppUser, AuthenticationResponse> {
    AuthenticationMapper INSTANCE = Mappers.getMapper(AuthenticationMapper.class);
}
