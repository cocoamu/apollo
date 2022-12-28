package com.example.demoapollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class DemoApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApolloApplication.class, args);
    }

}
