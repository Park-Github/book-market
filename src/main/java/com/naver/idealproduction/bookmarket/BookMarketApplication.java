package com.naver.idealproduction.bookmarket;

import jakarta.servlet.ServletContext;
import jakarta.servlet.SessionTrackingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;

import java.util.EnumSet;

@SpringBootApplication
public class BookMarketApplication implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BookMarketApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) {
		servletContext.setSessionTimeout(60);
		servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
	}
}
