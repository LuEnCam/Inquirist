package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class InquiristApplication
{
	@Autowired
	PersonnesRepository personsRepo;

	public static void main(String[] args)
	{
		SpringApplication.run(InquiristApplication.class, args);
	}

	@PostConstruct
	public void init()
	{
		for (int i = 0; i < 5; i++)
		{
			Person p = new Person();
			p.setNom("Chevre" + i);
			p.setPrenom("Sebastien" + i);

			personsRepo.save(p);
		}
	}
}
