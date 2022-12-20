package com.tjoeun.firstproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tjoeun.firstproject.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	// 특정 게시글의 모든 댓글을 조회하는 메소드
	// @Query 어노테이션으로 query를 만들어 사용할 수 있다.
	@Query(value = "select * from comment where article_id = :articleId", nativeQuery = true)
	List<Comment> findByArticleId(Long articleId);
	
	// 특정 닉네임과 모든 댓글을 조회하는 메소드
	// ORM은 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해주는 것을 말한다.
	// resources 폴더에 META_INF 폴더를 만들고 orm.xml 파일에 query를 만들어 사용할 수 있다.
	List<Comment> findByNickname(String nickname);
}
