package com.kgstrivers.bookshelf;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookshelfApplication {

	private static Logger log = LogManager.getLogger(BookshelfApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookshelfApplication.class, args);


		log.info("=======================Server Started=========================");
	}

}
