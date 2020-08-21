package com.yagudza.demo.service.impl;

import com.yagudza.demo.domain.User;
import com.yagudza.demo.dto.dtoIn.UserDtoIn;
import com.yagudza.demo.dto.dtoOut.UserDtoOut;
import com.yagudza.demo.mapper.impl.dtoToEntity.DtoToUserMapper;
import com.yagudza.demo.mapper.impl.entityToDto.UserToDtoMapper;
import com.yagudza.demo.repository.UserRepository;
import com.yagudza.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserToDtoMapper userToDtoMapper;
	private final DtoToUserMapper dtoToUserMapper;

	public UserServiceImpl(UserRepository userRepository
			, UserToDtoMapper userToDtoMapper
			, DtoToUserMapper dtoToUserMapper) {
		this.userRepository = userRepository;
		this.userToDtoMapper = userToDtoMapper;
		this.dtoToUserMapper = dtoToUserMapper;
	}

	@Override
	public Iterable<UserDtoOut> findAll() {
		final Iterable<User> users = userRepository.findAll();
		return userToDtoMapper.map(users);
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDtoOut save (UserDtoIn userDtoIn) {
		User user = dtoToUserMapper.map(userDtoIn);
		return userToDtoMapper.map(userRepository.save(user));
	}

	@Override
	public UserDtoOut findById(long id){
		return userToDtoMapper.map(userRepository.findById(id).orElseThrow());
	}

	@Override
	public boolean existsById(long id){
		return userRepository.existsById(id);
	}
}