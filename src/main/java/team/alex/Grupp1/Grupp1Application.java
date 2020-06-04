package team.alex.Grupp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "team.alex.Grupp1")
public class Grupp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupp1Application.class, args);
	}

}