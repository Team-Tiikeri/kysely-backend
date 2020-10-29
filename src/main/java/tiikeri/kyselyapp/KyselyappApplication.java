package tiikeri.kyselyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class KyselyappApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselyappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyappApplication.class, args);
	}

}
