package com.tjoeun.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tjoeun.firstproject.dto.ArticleForm;
import com.tjoeun.firstproject.entity.Article;
import com.tjoeun.firstproject.repository.ArticleRepository;

@Controller
public class ArticleController {
	
	// JPA Repository 인터페이스 객체를 선언하고 @Autowired로 초기화한다.
	@Autowired // SpringBoot가 미리 생성해놓은 객체를 가져다 자동으로 연결한다.
	private ArticleRepository articleRepository;

	@GetMapping("/articles/new")
	public String newArticleForm() {
		return "articles/new";
	}
	
	@PostMapping("/articles/create")
	// form에서 넘어오는 데이터는 커맨드 객체에 저장된다.
	public String createArticle(ArticleForm form) {
		System.out.println(form);
		
		// DTO의 데이터를 Entity로 변환한다.
		Article article = form.toEntity();
		System.out.println(article);
		
		// Repository에게 Entity를 데이터베이스에 저장하게 한다.
		// id가 자동으로 증가된다.
		Article saved = articleRepository.save(article);
		System.out.println(saved);
		
		return "articles/new";
	}
}
