package padeiro.exemplo.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import padeiro.exemplo.angular.config.proporty.PadeiroApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(PadeiroApiProperty.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

