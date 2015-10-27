package learningspringboot;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class TeamsApplication {

    private static final Logger log = LoggerFactory.getLogger(TeamsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TeamsApplication.class, args);
    }

    @Autowired(required = false)
    DatabaseLoader databaseLoader;

    @Autowired
    TeammateRepository teammateRepository;

    @PostConstruct
    void seeTheRoster() {
        for (Teammate teammate : teammateRepository.findAll()) {
            log.info(teammate.toString());
        }
    }
}
