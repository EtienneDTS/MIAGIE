package Serdaigle.MIAGIE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"Serdaigle.MIAGIE.controller", "Serdaigle.MIAGIE.model", "Serdaigle.MIAGIE.service", "Serdaigle.MIAGIE.repository"})
//@EntityScan({"Serdaigle.MIAGIE.controller", "Serdaigle.MIAGIE.model", "Serdaigle.MIAGIE.service", "Serdaigle.MIAGIE.repository"})
//@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactory")
public class MiagieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiagieApplication.class, args);
	}

}
