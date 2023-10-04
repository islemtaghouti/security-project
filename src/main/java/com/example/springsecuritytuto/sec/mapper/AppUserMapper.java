package com.example.springsecuritytuto.sec.mapper;

import com.example.springsecuritytuto.sec.config.EntityMapper;
import com.example.springsecuritytuto.sec.dto.UserRequest;
import com.example.springsecuritytuto.sec.dto.UserResponse;
import com.example.springsecuritytuto.sec.entities.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;


@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, componentModel = "spring")
public interface AppUserMapper extends EntityMapper<AppUser, UserResponse> {
    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);
}
