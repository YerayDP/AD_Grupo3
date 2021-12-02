package com.example.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Oferta;
import com.example.demo.models.OfertaModel;
import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService{

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserModel transform(User User)
	{
		ModelMapper modelmapper = new ModelMapper();
		return modelmapper.map(User, UserModel.class);
	}
	
	public User transform(UserModel Usermodel)
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Usermodel, User.class);
	}
	
	public com.example.demo.entity.User registrar(com.example.demo.entity.User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setActivo(true);
		user.setRole("ROLE_ALUMNO");
		return userRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.entity.User usuario=userRepository.findByEmail(username);
		
		UserBuilder builder=null;
		
		if(usuario!=null)
		{
			builder=User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));
		}
		else
			throw new UsernameNotFoundException("Usuario no encontrado");
		return builder.build();
	}
	
	//public UserModel findUserId (int id) {
		
	//	return transform(userRepository.findById(id));
	
		
	//}
}
