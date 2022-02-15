package com.example.demo.controller;

import java.sql.Date;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.models.InscritoModel;
import com.example.demo.models.UserModel;
import com.example.demo.service.InscritoService;
import com.example.demo.service.impl.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class APIController {
	
		@Autowired
		private AuthenticationManager authenticationManager;
	
	
		@Autowired
		@Qualifier("inscritoService")
		private InscritoService inscritoService;
		
		@Autowired
		@Qualifier("userService")
		private UserService userService;
		
		
		@GetMapping("/listInscritos")
		public List<InscritoModel> listarInscrito(@RequestHeader String token){
			return inscritoService.listAllInscritos();
		}
		
		@PostMapping("/login")
		public User login(@RequestBody User user) {
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = getJWTToken(user.getEmail());
			User u = new User();
			u = userService.transform(userService.findStudentMail(user.getEmail()));
			u.setToken(token);
			System.out.println("Token "+u.getToken());
			System.out.println(u.getRole());
			System.out.println(u.getEmail());
			System.out.println(u.getPassword());
			return u;
		}
		private String getJWTToken(String username) {
			String secretKey = "mySecretKey";
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_ALUMNO");
			
			String token = Jwts
					.builder()
					.setId("softtekJWT")
					.setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream()
									.map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512,
							secretKey.getBytes()).compact();

			return "Bearer " + token;
		}
		
	}
	
	

