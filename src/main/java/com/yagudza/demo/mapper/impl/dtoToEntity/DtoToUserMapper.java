package com.yagudza.demo.mapper.impl.dtoToEntity;

import com.yagudza.demo.domain.User;
import com.yagudza.demo.dto.dtoIn.UserDtoIn;
import com.yagudza.demo.mapper.IMapper;
import org.springframework.stereotype.Service;

@Service
public class DtoToUserMapper implements IMapper<UserDtoIn, User> {

    @Override
    public User map(UserDtoIn source) {
        if (source == null) {
            return null;
        }
        final var user = new User();
        user.setName(source.getName());
        user.setEmail(source.getEmail());
        user.setPassword(source.getPassword());
        return user;
    }
}
