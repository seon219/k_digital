package com.tjoeun.firstproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tjoeun.firstproject.api.ArticleApiController;
import com.tjoeun.firstproject.dto.ArticleForm;
import com.tjoeun.firstproject.entity.Article;
import com.tjoeun.firstproject.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Service 어노테이션을 붙여준 클래스는 springboot가 서비스로 인식하여 자동으로 객체를 생성해서 등록한다.
@Service
public class ArticleService {

	@Autowired // ArticleRepository 인터페이스 객체의 bean을 자동으로 주입받는다.
	private ArticleRepository articleRepository;
	
	
// Article 전체 목록 조회 실행
	public List<Article> index() {
		log.info("ArticleService index() 메소드 실행");
		return articleRepository.findAll();
	}
	
	// Article 단건(상세) 페이지 조회 
	public Article show(Long id) {

		log.info("ArticleService show() 메소드 실행");
		return articleRepository.findById(id).orElse(null);
	}

	// Article 생성 실행
	public Article create(ArticleForm dto) {
		log.info("ArticleService create() 메소드 실행");
		Article article = dto.toEntity();
		// id는 DB가 자동으로 생성하므로 id가 넘어오는 데이터는 저장하지 않는다.
		if(article.getId() != null) {
			return null;
		}

		return articleRepository.save(article);
	}

	
	// Article 수정 실행
	public Article update(Long id, ArticleForm dto) {
		log.info("ArticleService create() 메소드 실행");
		
		// 수정용 Entity를 생성
		Article article = dto.toEntity(); 
		// 수정할 Entity를 조회
		Article target = articleRepository.findById(id).orElse(null); 
		// 잘못된 요청 처리
		if (target == null || id != target.getId()) {
			log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
			return null;
		}
		target.patch(article);
		Article updated = articleRepository.save(target);
		return updated;
	}

	
	// Article 삭제 실행
	public Article delete(Long id) {
		log.info("ArticleService delete() 메소드 실행");
		
		// 삭제할 Entity를 조회한다.
		Article target = articleRepository.findById(id).orElse(null);
		// 잘못된 요청을 처리한다.
		if (target == null) {
			log.info("잘못된 요청! {}번 글은 테이블에 존재하지 않습니다.", id);
			return null;
		}
		
		articleRepository.delete(target);
		return target;
	}
	

	// 트랜잭션 실행
	// @Transactional 어노테이션은 해당 메소드를 트랜잭션으로 묶는다.
	@Transactional
	public List<Article> createArticles(List<ArticleForm> dtos) {
		log.info("ArticleService createArticles() 메소드 실행");
		// dto 묶음을 entity 묶음으로 변환한다.
		/*
		List<Article> articleList = new ArrayList<Article>();
		for(int i = 0; i < dtos.size(); i++) {
			Article entity = dtos.get(i).toEntity();
			articleList.add(entity);
		}
		*/
		List<Article> articleList = dtos.stream().map(dto -> dto.toEntity()).collect(Collectors.toList());
		log.info("articleList: {}", articleList);
		
		// entity 묶음을 DB로 저장한다.
		/*
		for (int i = 0; i < articleList.size(): i++) {
			articleRepository.save(articleList.get(i));
		}
		*/
		articleList.stream().forEach(article -> articleRepository.save(article));
		
		// 강제 예외 발생
		articleRepository.findById(-1L).orElseThrow(
				() -> new IllegalArgumentException("예외 메시지"));
		
		// 결과값 반환
		return articleList;
	}
}
