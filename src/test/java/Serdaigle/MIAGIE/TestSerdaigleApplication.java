package Serdaigle.MIAGIE;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestSerdaigleApplication {

	public static void main(String[] args) {
		SpringApplication.from(Serdaigle::main).with(TestcontainersConfiguration.class).run(args);
	}

}
