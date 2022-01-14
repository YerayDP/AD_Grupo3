package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.upload.StorageProperties;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class AdGrupo3Application {

	public static void main(String[] args) {
		SpringApplication.run(AdGrupo3Application.class, args);
		
	}

}
