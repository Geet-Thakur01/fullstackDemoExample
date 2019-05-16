package com.custom_web_app.mainpkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.custom_web_app.controller"})
public class MainClassHome {
	
	public static void main(String[] args) {
		SpringApplication.run(MainClassHome.class, args);
	}
}
