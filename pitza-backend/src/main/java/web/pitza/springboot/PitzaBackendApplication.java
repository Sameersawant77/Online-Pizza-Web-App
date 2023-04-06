package web.pitza.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PitzaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PitzaBackendApplication.class, args);
		System.out.println("Server has Started!!!");
	}

}
