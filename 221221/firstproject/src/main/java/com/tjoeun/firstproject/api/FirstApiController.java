package com.tjoeun.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

// Rest API용 컨트롤러는 @Controller 어노테이션이 아닌 @RestController 어노테이션으로 선언한다.
// @Controller 어노테이션은 뷰 템플릿(페이지)을 반환하지만, @RestController 어노테이션은 JSON을 반환한다.
@RestController
@Slf4j
public class FirstApiController {

	@GetMapping("/api/hello")
	public String hello() {
		log.info("FirstApiController의 hello() 메소드 실행");
		return "hello world";
	}
}
