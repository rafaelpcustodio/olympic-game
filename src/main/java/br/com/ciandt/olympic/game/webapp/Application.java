package br.com.ciandt.olympic.game.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Class responsible for setting up the application.
 *
 * @author rafaelcustodio
 */
@SpringBootApplication(scanBasePackages = "br.com.ciandt.olympic.game.webapp")
@EntityScan(basePackages = "br.com.ciandt.olympic.game.webapp.model.entity")
@EnableJpaRepositories(basePackages = "br.com.ciandt.olympic.game.webapp.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}