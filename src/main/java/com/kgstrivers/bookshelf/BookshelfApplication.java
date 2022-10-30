package com.kgstrivers.bookshelf;

import com.kgstrivers.bookshelf.Models.Role;
import com.kgstrivers.bookshelf.Models.User;
import com.kgstrivers.bookshelf.Services.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BookshelfApplication {

	private static Logger log = LogManager.getLogger(BookshelfApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookshelfApplication.class, args);
		log.info("=======================Server Started=========================");


	}

	@Bean
	PasswordEncoder passwordencoder()
	{
		return new BCryptPasswordEncoder();
	}


//	@Bean
//	CommandLineRunner run(UserService userservice)
//	{
//		return args -> {
//			userservice.saveRole(new Role(null,"SDE 1"));
//			userservice.saveRole(new Role(null,"SDE 2"));
//			userservice.saveRole(new Role(null,"SDE 3"));
//			userservice.saveRole(new Role(null,"SDE 4"));
//
//			userservice.saveUser(new User(null,"Kaushik Ghosh","kgstrivers","1234",new ArrayList<>()));
//			userservice.saveUser(new User(null,"Asim Mitra","asimM","12345",new ArrayList<>()));
//			userservice.saveUser(new User(null,"Gourab Banik","gbbanik","1234",new ArrayList<>()));
//			userservice.saveUser(new User(null,"yuflrf","tyuiop","1234",new ArrayList<>()));
//
//			userservice.addRoletoUser("kgstrivers","SDE 1");
//			userservice.addRoletoUser("asimM","SDE 1");
//			userservice.addRoletoUser("gbbanik","SDE 1");
//			userservice.addRoletoUser("tyuiop","SDE 1");
//		};
//	}

}
