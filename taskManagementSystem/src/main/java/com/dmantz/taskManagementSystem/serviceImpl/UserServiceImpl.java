package com.dmantz.taskManagementSystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmantz.taskManagementSystem.entity.Users;
import com.dmantz.taskManagementSystem.payload.UserDto;
import com.dmantz.taskManagementSystem.repository.UserRepository;
import com.dmantz.taskManagementSystem.service.UserService;
@Service
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		Users users=userDtoToEntity(userDto);// converted userDto to Users
		Users savedUsers=userRepository.save(users);
		return entityToUserDto(savedUsers);
	}
	
	private Users userDtoToEntity(UserDto userDto) {
		
		Users users=new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		return users;
		
		
	}
private UserDto entityToUserDto(Users savedUsers) {
		
		UserDto userDto=new UserDto();
		userDto.setName(savedUsers.getName());
		userDto.setEmail(savedUsers.getEmail());
		userDto.setPassword(savedUsers.getPassword());
		return userDto;
		
		
	}


}
