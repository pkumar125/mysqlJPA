package com.appsdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.appsdeveloperblog.app.ws.data.UserEntity;
import com.appsdeveloperblog.app.ws.data.UsersRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{

	Map<String, UserRest> users;
	Utils utils;
	UsersRepository usersRepository;
	
	public UserServiceImpl() {}

	@Autowired
	public  UserServiceImpl( UsersRepository usersRepository){
		this.usersRepository = usersRepository;

	}
	
	@Autowired
	public UserServiceImpl(Utils utils)
	{
		this.utils =utils;
	}
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		String userId = utils.generateUserId();
		userDetails.setUserId(userId);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword("test");
		usersRepository.save(userEntity);

		UserRest returnValue = modelMapper.map(userEntity, UserRest.class);

		return returnValue;
		//return UserRest;
		
	}

}
