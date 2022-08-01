package com.game.TestGame;

import com.game.TestGame.Model.Address;
import com.game.TestGame.Model.Student;
import com.game.TestGame.Service.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class GameTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameTestApplication.class, args);
		System.out.println("listening on 9089");
	}
/*
	@Bean
	CommandLineRunner runner(TestRepository rep){
		log.info("update shit");
		return args -> {
			rep.save(new Student("andrasi",
					"benedek",
					new Address("hungary",
							"nyiregyhaza"),
					List.of("sut the", "fuck up")));
		};
	}

 */



}
