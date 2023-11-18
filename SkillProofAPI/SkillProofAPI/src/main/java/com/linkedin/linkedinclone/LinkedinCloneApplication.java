package com.linkedin.linkedinclone;

import com.linkedin.linkedinclone.enumerations.RoleType;
import com.linkedin.linkedinclone.model.Role;
import com.linkedin.linkedinclone.model.User;
import com.linkedin.linkedinclone.repositories.PictureRepository;
import com.linkedin.linkedinclone.repositories.RoleRepository;
import com.linkedin.linkedinclone.repositories.UserRepository;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LinkedinCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedinCloneApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*");
			}
		};
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository, RoleRepository roleRepository, PictureRepository pictureRepository, BCryptPasswordEncoder encoder) {
		return args -> {

			if(userRepository.findByRole(RoleType.ADMIN).size() == 0){
				Role admin_role = new Role(RoleType.ADMIN);
				roleRepository.save(admin_role);
				Role prof_role = new Role(RoleType.PROFESSIONAL);
				roleRepository.save(prof_role);

				User user = new User(
						"admin@mail.com",
						encoder.encode("012345"),
						"admin",
						"admin"
				);
				Set<Role> roles = new HashSet<Role>();
				roles.add(admin_role);
				roles.add(prof_role);
				user.setRoles(roles);
				userRepository.save(user);
			}
		};
	}

}
