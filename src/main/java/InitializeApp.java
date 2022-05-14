import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages={"com.alarm.system"})
@EnableAutoConfiguration
@SpringBootApplication
public class InitializeApp {
    public static void main(String[] args) {
        SpringApplication.run(InitializeApp.class, args);
    }
}