package com.clean.app.web; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class SystemCleanApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SystemCleanApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		String password = "cii$2020";
		for(int i=0; i<3; i++) {
			String encrypt = passwordEncoder.encode(password);
			System.out.println(encrypt);
		}	
	}
}
