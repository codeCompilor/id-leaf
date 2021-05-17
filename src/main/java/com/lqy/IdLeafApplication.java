package com.lqy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.sankuai.inf.leaf.plugin.annotation.EnableLeafServer;

@EnableLeafServer
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
public class IdLeafApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdLeafApplication.class, args);
	}
}
