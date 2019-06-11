package com.liebe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(basePackages = "com.liebe.sys.dao", annotationClass = javax.annotation.Resource.class)
@ImportResource(locations={"classpath:conf/*"})

public class GirlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GirlApplication.class, args);
	}
}
