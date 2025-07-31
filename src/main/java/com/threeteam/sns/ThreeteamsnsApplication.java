package com.threeteam.sns;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.threeteam.sns.mapper")
public class ThreeteamsnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreeteamsnsApplication.class, args);
	}

}