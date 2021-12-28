/**
 * Spring boot MVC Remote Service
 * Tomcat Base 구동
 */
package com.example.nonblockingcallee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
public class NonblockingCalleeApplication {

	@RestController
	public static class MyController {

		/**
		 * 1 초 소요 서비스
		 */
		@GetMapping("/service1")
		public String service1(String req) throws InterruptedException {
			Thread.sleep(1000); // 1초 대기
			return req + " / service1";
		}

		/**
		 * 1 초 소요 서비스
		 */
		@GetMapping("/service2")
		public String service2(String req) throws InterruptedException {
			Thread.sleep(1000); // 1초 대기
			return req + " / service2";
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(NonblockingCalleeApplication.class, args);
	}

}
