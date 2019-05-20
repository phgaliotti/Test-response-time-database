package com.test.responsetimedatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.responsetimedatabase.usecase.ExecuteQueryUseCase;

@SpringBootApplication
public class ResponseTimeDatabaseApplication implements CommandLineRunner {

	@Autowired
	private ExecuteQueryUseCase executeQueryUseCase;

	public static void main(String[] args) {
		SpringApplication.run(ResponseTimeDatabaseApplication.class, args);
	}
	
	@Override
	public void run(String... stringsArgs) throws Exception {
		System.out.println("=================================================="); 
		executeQueryUseCase.execute();
		System.out.println("==================================================");
	}

}
