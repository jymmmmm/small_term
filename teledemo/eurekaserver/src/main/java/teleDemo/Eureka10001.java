package teleDemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka10001 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka10001.class,args);
    }
}
