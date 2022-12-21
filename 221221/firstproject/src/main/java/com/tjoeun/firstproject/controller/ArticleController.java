package com.tjoeun.firstproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tjoeun.firstproject.dto.ArticleForm;
import com.tjoeun.firstproject.dto.commentDto;
import com.tjoeun.firstproject.entity.Article;
import com.tjoeun.firstproject.repository.ArticleRepository;
import com.tjoeun.firstproject.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // 롬복에서 지원하는 로그 어노테이션
public class ArticleController {
	
	// JPA Repository 인터페이스 객체를 선언하고 @Autowired로 초기화한다.
	@Autowired // SpringBoot가 미리 생성해놓은 객체를 가져다 자동으로 연결한다.
	private ArticleRepository articleRepository;

	
	// 댓글 목록을 가져오기 위해 CommentService 클래스의 bean을 얻어온다
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping("/articles/new")
	public String newArticleForm() {
		// 롬복이 제공하는 @Slf4j 어노테이션으로 로그를 출력할 수 있다. 로그는 반드시 문자열로 지정한다.
		// log.trace(): 가장 디테일한 로그
		// log.warn(): 경고 로그
		// log.info(): 정보성 로그
		// log.debug(): 디버깅용 로그
		// log.error(): 에러 로그
		log.info("컨트롤러의 newArticleForm() 메소드 실행");
		return "articles/new";
	}
	
	@PostMapping("/articles/create")
	// form에서 넘어오는 데이터는 커맨드 객체에 저장된다.
	public String createArticle(ArticleForm form) {
		log.info("컨트롤러의 createArticle() 메소드 실행");
		//System.out.println(form);
		log.info(form.toString());
		
		// DTO의 데이터를 Entity로 변환한다.
		Article article = form.toEntity();
		//System.out.println(article);
		log.info(article.toString());
		
		// Repository에게 Entity를 데이터베이스에 저장하게 한다.
		// id가 자동으로 증가된다.
		Article saved = articleRepository.save(article);
		//System.out.println(saved);
		log.info(saved.toString());
		
		return "redirect:/articles"; // 목록보기
		//return "redirect:/articles" + saved.getId(); // 작성한 글 보기
	}
	
	
	// 브라우저에서 /article/글번호 형태의 요청을 받아 처리한다.
	// {}는 변경되는 데이터를 받는다.
	@GetMapping("/articles/{id}")
	// {}를 통해서 받는 데이터를 저장할 변수는 @PathVariable 어노테이션을 붙여서 선언한다.
	public String show(@PathVariable Long id, Model model) {
		log.info("컨트롤러의 show() 메소드 실행");
		log.info("id = " + id);
		
		// 메인글을 얻어온다.
		// articleRepository의 findById() 메소드로 인수로 지정한 id에 해당되는데이터 1건을 테이블에서 가져온다.
		// findById() 메소드로 얻어온 데이터가 없으면 orElse() 메소드로 null을 리턴시킨다.
		Article articeEntity = articleRepository.findById(id).orElse(null);
		// 테이블에서 가져온 데이터를 show.mustache 파일로 넘기기 위해 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("article", articeEntity);
		
		
		// 댓글 목록을 얻어온다.
		// 테이블에서 가져온 댓글을 show.mustache 파일로 넘기기 위해 Model 인터페이스 객체에 넣어준다.
		List<commentDto> commentsDtos = commentService.comments(id);
		// 테이블에서 가져온 댓글 목록을 show.mustache 파일로 넘기기 위해 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("commentsDtos", commentsDtos);
		log.info("commentsDtos: {}", commentsDtos);
				
		
		// 뷰 페이지를 설정한다.
		return "articles/show";
	}
	
	
	@GetMapping("/articles")
	public String index(Model model) {
		log.info("컨트롤러의 index() 메소드 실행");
		
		// 테이블에 저장된 모든 글 목록을 얻어온다.
		List<Article> articleEntitiyList = articleRepository.findAll();
		log.info(articleEntitiyList + "");
		// 가져온 글 목록을 index.mustache로 넘겨주기 위해 Model 객체에 저장한다.
		model.addAttribute("articleList", articleEntitiyList);
		
		return "articles/index";
	}
	
	
	@GetMapping("/articles/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		log.info("컨트롤러의 edit() 메소드 실행");
		log.info("수정할 id = " + id);
		
		// 수정할 데이터를 얻어온다.
		Article articeEntity = articleRepository.findById(id).orElse(null);
		// 수정할 데이터를 edit.mustache 파일로 넘기기 위해 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("article", articeEntity);
		
		return "articles/edit";
	}
	
	
	@PostMapping("/articles/update")
	// from에서 넘어오는 데이터 전체를 받기 위해 커맨드 객체를 사용한다.
	public String update(ArticleForm form) {
		log.info("컨트롤러의 update() 메소드 실행");
		log.info(form.toString());
		
		// DTO를 Entity로 변환한다.
		Article article = form.toEntity();
		log.info(form.toString());
		
		// 데이터베이스에 저장된 수정할 데이터를 얻어와서 Entity로 수정한 후 데이터베이스에 저장
		Article target = articleRepository.findById(article.getId()).orElse(null);
		if (target != null) {
			articleRepository.save(article);
		}
		
		// 글 1건 수정이 완료되었으므로 redirect를 이용해서 보기나 작성한 글 보기로 넘겨준다.
		return "redirect:/articles"; // 목록보기
		
		 //return "redirect:/articles" + article.getId(); // 수정할 글 보기
	}
	
	
	@GetMapping("/articles/{id}/delete")
	// RedirectAttributes 인터페이스는 뷰 페이지로 1회성 메시지 전달에 사용된다.
	public String delete(@PathVariable Long id, RedirectAttributes attributes) {
		log.info("컨트롤러의 delete() 메소드 실행");
		log.info("수정할 id = " + id);
		
		// 삭제할 데이터를 가져온다.
		Article target = articleRepository.findById(id).orElse(null);
		log.info(target.toString());
		
		// 데이터를 삭제한다,
		if (target != null) {
			articleRepository.delete(target);
			
			// addFlashAttribute() 메소드로 1회성으로 1번만 사용할 메시지를 뷰 페이지로 전달한다.
			attributes.addFlashAttribute("msg", id + "번 글 삭제 완료");
		}
		
		return "redirect:/articles"; // 목록보기
	}
}
