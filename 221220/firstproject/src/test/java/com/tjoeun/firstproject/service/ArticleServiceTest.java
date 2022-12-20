package com.tjoeun.firstproject.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tjoeun.firstproject.dto.ArticleForm;
import com.tjoeun.firstproject.entity.Article;

// @SpringBootTest 어노테이션을 붙여 스프링 부트와 연동한 통합 테스트를 수행한다.
@SpringBootTest
class ArticleServiceTest {

	@Autowired 
	private ArticleService articleService;
	
	@Test
	void testIndex() {
		// 예상
		Article article1 = new Article(1L, "홍길동", "천재");
		Article article2 = new Article(2L, "임꺽정", "처언재");
		Article article3 = new Article(3L, "장길산", "처언언재");
		Article article4 = new Article(4L, "일지매", "처언언언재");
		List<Article> expected = new ArrayList<Article>(Arrays.asList(article1, article2, article3, article4));
		// 실제
		List<Article> articles = articleService.index();
		// 비교
		assertEquals(expected.toString(), articles.toString());
	}

	@Test
	void testShow_성공_존재하는id() {
		// 예상
		Long id = 1L;
		Article expected = new Article(id, "홍길동", "천재");
		// 실제
		Article articles = articleService.show(id);
		// 비교
		assertEquals(expected.toString(), articles.toString());
	}
	
	@Test
	void testShow_실패_존재하지않는id() {
		// 예상
		Long id = -1L;
		Article expected = null;
		// 실제
		Article articles = articleService.show(id);
		// 비교
		assertEquals(expected, articles);
	}

	// 테이블이 변경되는 테스트를 실행하는 경우 이전 테스트의 영향을 받아서 하나씩 테스트 할 때는 정삭적으로 실행되던 테스트가
	// 오류가 발생할 수 있기 때문에 테스트 결과가 테이블을 변경시키는 테스트는 @Transactional 어노테이션을 붙여서 
	// 테스트가 끝나면 롤백하도록 해야 한다,
	
	@Test
	// @Transactional 어노테이션은 테스트 종료 후 변경된 데이터를 롤백으로 처리한다.
	@Transactional
	void testCreate_성공_title과_content만_있는_dto입력() {
		String title = "홍길동";
		String content = "수리수리마수리";
		ArticleForm dto = new ArticleForm(null, title, content);
		// 예상
		Article expected = new Article(5L, title, content);
		// 실제
		Article article = articleService.create(dto);
		// 비교
		assertEquals(expected.toString(), article.toString());
		
	}
	
	@Test
	@Transactional
	void testCreate_실패_id가_입력된_dto입력() {
		String title = "홍길동";
		String content = "수리수리마수리";
		ArticleForm dto = new ArticleForm(5L, title, content);
		// 예상
		Article expected = null;
		// 실제
		Article article = articleService.create(dto);
		// 비교
		assertEquals(expected, article);
	}

	@Test
	@Transactional
	void testUpdate_성공_존재하는_id와_title_content가_있는_dto입력() {
		Long id = 1L;
		String title = "홍길동";
		String content = "수리수리마수리";
		ArticleForm dto = new ArticleForm(id, title, content);
		// 예상
		Article expected = new Article(1L, "홍길동", "수리수리마수리");
		// 실제
		Article article = articleService.update(id, dto);
		// 비교
		assertEquals(expected.toString(), article.toString());
	}
	
	@Test
	@Transactional
	void testUpdate_성공_존재하는_id와_title만_있는_dto입력() {
		Long id = 1L;
		String title = "홍길동";
		String content = null;
		ArticleForm dto = new ArticleForm(id, title, content);
		// 예상
		Article expected = new Article(1L, "홍길동", "천재");
		// 실제
		Article article = articleService.update(id, dto);
		// 비교
		assertEquals(expected.toString(), article.toString());
	}
	
	@Test
	@Transactional
	void testUpdate_성공_존재하는_id와_content만_있는_dto입력() {
		Long id = 1L;
		String title = null;
		String content = "수리수리마수리";
		ArticleForm dto = new ArticleForm(id, title, content);
		// 예상
		Article expected = new Article(1L, "홍길동", "수리수리마수리");
		// 실제
		Article article = articleService.update(id, dto);
		// 비교
		assertEquals(expected.toString(), article.toString());
	}
	
	@Test
	@Transactional
	void testUpdate_실패_존재하지_않는_id의_dto입력() {
		Long id = 5L;
		String title = null;
		String content = "수리수리마수리";
		ArticleForm dto = new ArticleForm(id, title, content);
		// 예상
		Article expected = null;
		// 실제
		Article article = articleService.update(id, dto);
		// 비교
		assertEquals(expected, article);
	}
	
	@Test
	@Transactional
	void testUpdate_실패_id만_있는_dto입력() {
		Long id = 5L;
		String title = null;
		String content = null;
		ArticleForm dto = new ArticleForm(id, title, content);
		// 예상
		Article expected = null;
		// 실제
		Article article = articleService.update(id, dto);
		// 비교
		assertEquals(expected, article);
	}

	@Test
	@Transactional
	void testDelete_성공_존재하는_id입력() {
		Long id = 3L;
		String title = "장길산";
		String content = "처언언재";
		// 예상
		Article expected = new Article(id, title, content);
		// 실제
		Article article = articleService.delete(id);
		// 비교
		assertEquals(expected.toString(), article.toString());
	}

	@Test
	@Transactional
	void testDelete_실패_존재하지_않는_id입력() {
		Long id = 5L;
		// 예상
		Article expected = null;
		// 실제
		Article article = articleService.delete(id);
		// 비교
		assertEquals(expected, article);
	}

}
