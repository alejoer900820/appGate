package co.com.appgate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Alejandro Echeverri Restrepo
 * 
 * Class is used for running the application  
 * 
 * date 28/06/2020
 *
 */
@SpringBootApplication
public class TestValidApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(TestValidApplication.class, args);
	}
	


}
