package com.tjoeun.firstproject.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tjoeun.firstproject.entity.Article;
import com.tjoeun.firstproject.entity.Comment;

// @SpringBootTest 어노테이션을 붙여주면 스프링 부트와 연동한 통합 데이터를 수행한다.
// @DataJpaTest 어노테이션을 붙여주면 JPA와 연동한 테스트를 수행한다.

@DataJpaTest
class CommentRepositoryTest {

	@Autowired
	CommentRepository commetRepository;
	
	@Test
	// @DisplayName 어노테이션으로 테스트 결과에 보여줄 이름을 지정한다.
	@DisplayName("특정 게시글의 모든 댓글 조회")
	void testFindByArticleId() {
		{
			// 5번 게시글의 모든 댓글 조회
			Long articleId = 5L;
			// 예상
			Article article = new Article(5L, "손오공", "좋아하는 드라마는?");
			Comment comment1 = new Comment(1L, "한꼬마", "재벌집 막내아들", article);
			Comment comment2 = new Comment(2L, "두꼬마", "슬기로운 의사생활", article);
			Comment comment3 = new Comment(3L, "세꼬마", "빈센조", article);
			List<Comment> expected = Arrays.asList(comment1, comment2, comment3);
			// 실제
			List<Comment> actual = commetRepository.findByArticleId(articleId);
			// 비교
			// assertEquals() 메소드의 3번째 인수로 테스트 결과가 올바르지 않을 때 출력할 메시지를 지정할 수 있다.
			assertEquals(expected.toString(), actual.toString(), "5번 댓글의 모든 댓글을 출력");
		}
		
		{
			// 1번 게시글의 모든 댓글 조회
			Long articleId = 1L;
			// 예상
			List<Comment> expected = Arrays.asList();
			// 실제
			List<Comment> actual = commetRepository.findByArticleId(articleId);
			// 비교
			assertEquals(expected.toString(), actual.toString(), "1번 댓글의 모든 댓글을 출력");
		}
	}

	
	
	@Test
	@DisplayName("특정 닉네임의 모든 댓글 조회")
	void testFindByNickname() { 
		{
			// "한꼬마" 닉네임의 모든 댓글 조회
			String nickname = "한꼬마";
			// 예상
			Comment comment1 = new Comment(1L, nickname, "재벌집 막내아들", new Article(5L, "손오공", "좋아하는 드라마는?"));
			Comment comment2 = new Comment(4L, nickname, "짜장면", new Article(6L, "저팔계", "먹고싶은 음식은?"));
			Comment comment3 = new Comment(7L, nickname, "영화", new Article(7L, "사오정", "취미는?"));
			List<Comment> expected = Arrays.asList(comment1, comment2, comment3);
			// 실제
			List<Comment> actual = commetRepository.findByNickname(nickname);
			// 비교
			// assertEquals() 메소드의 3번째 인수로 테스트 결과가 올바르지 않을 때 출력할 메시지를 지정할 수 있다.
			assertEquals(expected.toString(), actual.toString(), "한꼬마의 모든 댓글을 출력");
		}
	}
}
