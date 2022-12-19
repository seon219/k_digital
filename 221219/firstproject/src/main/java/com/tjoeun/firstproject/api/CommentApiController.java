package com.tjoeun.firstproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tjoeun.firstproject.dto.commentDto;
import com.tjoeun.firstproject.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CommentApiController {

	// CommentService의 메소드를 사용하기 위해서 @Autowired 어노테이션을 붙여서 CommentService의 bean을 가져온다. 
	@Autowired
	private CommentService commentService;
	
	// 댓글 목록 조회 요청
	// Talend API Tester(GET) => http://localhost:9090/api/comments/5/comments
	@GetMapping("/api/comments/{articleId}/comments")
	public ResponseEntity<List<commentDto>> comments(@PathVariable Long articleId) {
		log.info("commentService의 comments() 메소드");
		log.info("articleId: {}", articleId);
		
		// 서비스에 위임
		List<commentDto> dtos = commentService.comments(articleId);
		// 결과 응답
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
}
