package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Locale;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        String[] isoCountries = Locale.getISOCountries();

        Arrays.stream(isoCountries).map(s -> new Locale("", s)).forEach(locale -> {
            System.out.println("Code: " + locale.getCountry() + ", Name: " + locale.getDisplayCountry());
        });
        SpringApplication.run(MainApplication.class, args);
    }
}
