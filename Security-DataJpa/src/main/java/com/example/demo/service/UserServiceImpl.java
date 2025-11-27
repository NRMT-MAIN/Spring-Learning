package com.example.demo.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserDetails;
import com.example.demo.repository.IUserRepository;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepo ; 
	
	@Override
	public String registerUser(UserDetails details) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ; 
		
		details.setPwd(encoder.encode(details.getPwd()));
		
		int idVal = userRepo.save(details).getUnid() ; 
		return "User is registered with the id : "  + idVal;
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<UserDetails> opt = userRepo.findByUname(username) ; 
		if (opt.isEmpty()) {
            throw new UsernameNotFoundException(username + " not found!");
        }
		
		UserDetails user = opt.get() ; 
		
        Set<GrantedAuthority> authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role))
            .collect(Collectors.toSet());

       
        return new User(
            user.getUname(), 
            user.getPwd(), 
            user.getStatus(), 
            true, 
            true, 
            true, 
            authorities
        );
	}
}
