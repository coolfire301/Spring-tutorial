package com.example.Login_password;

import com.example.Login_password.Construct.Users;
import com.example.Login_password.Repository.AppRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginPasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginPasswordApplication.class, args);
	}

	@Bean(name = "pwdEncoder")
	public PasswordEncoder getPasswordEncoder() {
		DelegatingPasswordEncoder delPasswordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories
				.createDelegatingPasswordEncoder();
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
		return delPasswordEncoder;
	}
	@Bean
	CommandLineRunner commandLineRunner(AppRepository repository) {
		return args -> {
			repository.save(new Users("Jack", new BCryptPasswordEncoder().encode("Bauer")));
			repository.save(new Users("Chloe",new BCryptPasswordEncoder().encode("O'Brian")));
			repository.save(new Users("Kim", new BCryptPasswordEncoder().encode("Bauer")));
			repository.save(new Users("David",new BCryptPasswordEncoder().encode( "Palmer")));
			repository.save(new Users("Michelle",new BCryptPasswordEncoder().encode("Dessler")));
			repository.save(new Users("Timo", new BCryptPasswordEncoder().encode("123")));

		};
	}
}
