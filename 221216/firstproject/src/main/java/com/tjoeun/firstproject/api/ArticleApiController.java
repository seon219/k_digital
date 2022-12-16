package com.tjoeun.firstproject.api;

import java.util.List;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tjoeun.firstproject.dto.ArticleForm;
import com.tjoeun.firstproject.entity.Article;
import com.tjoeun.firstproject.repository.ArticleRepository;
import com.tjoeun.firstproject.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

// @RestController 어노테이션은 REST API용 컨트롤러로 사용됨을 의미
// 뷰 템플릿 형식이 아닌 JSON형식의 데이터를 반환한다.
@RestController
@Slf4j
public class ArticleApiController {
	
	// com.tjoeun.firstproject 패키지에 service 패키지를 추가하고 ArticleApiController에서 DB에 접속해서 처리하는 부분을
	// ArticleService 클래스로 넘긴다.
	
	// ArticleApiController에서 만들어 사용하던 ArticleRepository는 ArticleService 클래스로 넘기고
	// ArticleRepository는 ArticleService 클래스 객체를 만들어 사용한다.
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired // ArticleService 인터페이스 객체의 bean을 자동으로 주입받은다.
	private ArticleService articleService;
	
	// Article 전체 목록 조회
	@GetMapping("/api/articles")
	public List<Article> index() {
		log.info("ArticleApiController index() 메소드 실행");
		//return articleRepository.findAll();
		return articleService.index();
	}
	
	@GetMapping("/api/articles/{id}")
	public Article show(@PathVariable Long id) {
		log.info("ArticleApiController show() 메소드 실행");
		//return articleRepository.findById(id).orElse(null);
		return articleService.show(id);
	}
	
	@PostMapping("/api/articles")
	// form에서 데이터를 받아올 때는 커멘드 객체로 받으면 되지만 REST API에서 JSON으로 던지는 데이터를 받을 때는
	// body 부분에 담겨오는 데이터를 받아야 하므로 커맨드 객체에 @RequestBody 어노테이션을 붙여서 받아야 한다.
	
	// 데이터를 테이블에 저장하고 저장한 데이터를 리턴시킨다.
	// 상태 코드를 담아서 리턴하려면 ResponseEntity 객체를 사용해야 한다.
	// ResponseEntity<Article>를 리턴 타입으로 사용하면 ResponseEntity 객체에 Article을 담아서 리턴한다.
	public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
		log.info("ArticleApiController create() 메소드 실행");
		log.info(dto.toString());
		//Article saved = articleRepository.save(dto.toEntity());
		//return ResponseEntity.status(HttpStatus.CREATED).body(saved); //HttpStatus.CREATED: 201
		Article saved = articleService.create(dto);
		// body() 메소드는 body에 데이터를 담아서 넘기고 build() 메소드는 body 없이 넘긴다.
		return saved != null ? ResponseEntity.status(HttpStatus.CREATED).body(saved) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	/*
	// 데이터를 테이블에 저장한다.
	public void create(@RequestBody ArticleForm dto) {
		log.info("ArticleApiController create() 메소드 실행");
		log.info(dto.toString());
		Article saved = articleRepository.save(dto.toEntity());
	}
	*/
	
	
	// Article 수정 요청
	@PatchMapping("/api/articles/{id}")
	public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
		log.info("ArticleApiController update() 메소드 실행");
		log.info("id: " + id);
		log.info(dto.toString());
		
		/*
		// 수정용 Entity를 생성한다.
		Article article = dto.toEntity();
		log.info("id: {}, article: {}", id, article.toString());
		
		// 수정할 Entity를 조회한다.
		Article target = articleRepository.findById(id).orElse(null); // 수정할 데이터
		try {
			log.info("target: {}", target.toString());			
		} catch(NullPointerException e) {
			log.info("target: null");						
		}
		
		// 잘못된 요청(수정할 대상이 없거나 id가 다른 경우)을 처리한다.
		if (target == null || id != target.getId()) {
			// 잘못된 요청 응답, 400
			log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
			// ResponseEntity 객체에 400 상태코드를 저장하고 body에는 아무것도 저장하지 않는다.
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		// 수정 후 정상 응답을 보낸다.
		// @RequestBody를 통해 ArticleForm으로 넘어오는 수정할 데이터의 일부가 넘어오지 않으면
		// 넘어오지 않은 데이터는 null이 되므로 수정 시 에러가 발생한다.
		// 이런 현상을 방지하기 위해서 조회된 수정할 Entity를 @RequestBody를 통해 넘어온 데이터가 있는 경우만 수정하기 위해서
		// Entity(Article) 클래스에 넘어오지 않은 데이터가 기존 값을 유지시키는 메소드를 만들어 실행한 후 수정한다.
		target.patch(article);
		Article updated = articleRepository.save(target);
		
		// ResponseEntity 객체에 200 상태 코드를 저장하고 body에는 수정할 데이터를 저장한다.
		return ResponseEntity.status(HttpStatus.OK).body(article);
		*/
		
		Article updated = articleService.update(id, dto);
		return updated != null ? ResponseEntity.status(HttpStatus.OK).body(updated) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
	
	@DeleteMapping("/api/articles/{id}")
	public ResponseEntity<Article> delete(@PathVariable Long id) {
		log.info("ArticleApiController delete() 메소드 실행");
		log.info("id: " + id);
		
		/*
		// 삭제할 Entity를 조회한다.
		Article target = articleRepository.findById(id).orElse(null);
		try {
			log.info("target: {}", target.toString());			
		} catch(NullPointerException e) {
			log.info("target: null");						
		}
		
		// 잘못된 요청을 처리한다.
		if (target == null || id != target.getId()) {
			log.info("잘못된 요청! {}번 글은 테이블에 존재하지 않습니다.", id);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		// 삭제 후 정상 응답을 보낸다,
		articleRepository.delete(target);
		// ResponseEntity 객체에 204 상태 코드를 저장하고 body에는 아무것도 저장하지 않는다.
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // HttpStatus.NO_CONTENT: 204
		*/
		
		Article delete = articleService.delete(id);
		return delete != null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
	
	// 트랜젝션 요청 
	@PostMapping("/api/transaction-test")
	public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){
		log.info("ArticleApiController transactionTest() 메소드 실행");
		log.info("dtos: {}", dtos);
		
		List<Article> createList =  articleService.createArticles(dtos);
		
		return createList != null ? ResponseEntity.status(HttpStatus.OK).body(createList) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}
