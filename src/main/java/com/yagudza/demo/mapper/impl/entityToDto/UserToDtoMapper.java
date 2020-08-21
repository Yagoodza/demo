package com.yagudza.demo.mapper.impl.entityToDto;

import com.yagudza.demo.domain.User;
import com.yagudza.demo.dto.dtoOut.UserDtoOut;
import com.yagudza.demo.mapper.IMapper;
import org.springframework.stereotype.Service;

@Service
public class UserToDtoMapper implements IMapper<User, UserDtoOut> {

    @Override
    public UserDtoOut map(User source) {
        if (source == null) {
            return null;
        }
        final var userDto = new UserDtoOut();
        userDto.setId(source.getId());
        userDto.setEmail(source.getEmail());
        userDto.setName(source.getName());
        return userDto;
    }
}
