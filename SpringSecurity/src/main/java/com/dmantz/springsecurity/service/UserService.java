package com.dmantz.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dmantz.springsecurity.common.User;
import com.dmantz.springsecurity.config.UserPrinciple;
import com.dmantz.springsecurity.reposotory.UserRepo;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=repo.findByUsername(username);
		if(user==null) 
			throw new UsernameNotFoundException(username+"not found in database");
		
		return new UserPrinciple(user);
	}

}
