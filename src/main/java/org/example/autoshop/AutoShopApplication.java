package org.example.autoshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@EnableSwagger2
public class AutoShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoShopApplication.class, args);

        String url = "jdbc:sqlserver://DESKTOP-0ID3U44\\SQLEXPRESS;databaseName=AutoWorkshop";
        String username = "sa";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Підключення успішне!");
            }
        } catch (
                SQLException e) {
            System.out.println("Помилка підключення: " + e.getMessage());
        }
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.autoshop"))
                .paths(PathSelectors.any())
                .build();
    }

}
