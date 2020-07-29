package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.StudentDBApplication;


@ComponentScan //Tells Spring to scan for annotated component in any connected file
@SpringBootApplication  //must be kept in the base package and enables scanning of associated sub-packages
public class StudentDBApplication extends SpringBootServletInitializer{

		@Override //overloads an instance method to add new behavior
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(StudentDBApplication.class);
		}
		public static void main(String[] args) {
		SpringApplication.run(StudentDBApplication.class, args);
	}

}
