package com.xzf.demo_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xzf
 */
@SpringBootApplication
@MapperScan({"com.xzf.demo_mybatis.comment.dao",
		"com.xzf.demo_mybatis.tv.dao"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

