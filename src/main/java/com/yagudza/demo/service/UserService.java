package com.yagudza.demo.service;

import com.yagudza.demo.dto.dtoIn.UserDtoIn;
import com.yagudza.demo.dto.dtoOut.UserDtoOut;

public interface UserService {

	Iterable<UserDtoOut> findAll();

	void deleteById(long id);

	UserDtoOut save (UserDtoIn userDtoIn);

	UserDtoOut findById(long id);

	boolean existsById(long id);
}
