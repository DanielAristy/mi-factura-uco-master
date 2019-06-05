package co.edu.uco.facturanet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "co.edu.uco.facturanet")
@EnableJpaRepositories(basePackages = "co.edu.uco.facturanet")
@EntityScan(basePackages = "co.edu.uco.facturanet")
public class FacturaNetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturaNetApiApplication.class, args);
	}

}
