package com.tjoeun.firstproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		log.info("CommentApiController의 comments() 메소드");
		log.info("articleId: {}", articleId);
		
		// 서비스에 위임
		List<commentDto> dtos = commentService.comments(articleId);
		// 결과 응답
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
	
	// 댓글 생성 요청
	// Talend API Tester(POST) => http://localhost:9090/api/comments/5/comments
	@PostMapping("/api/comments/{articleId}/comments")
	public ResponseEntity<commentDto> create(@PathVariable Long articleId, @RequestBody commentDto dto) {
		log.info("CommentApiController의 create() 메소드");
		log.info("컨트롤러 create articleId: {}", articleId);
		log.info("컨트롤러 create dto: {}", dto);
		
		// 서비스에 위임
		commentDto createDto = commentService.create(articleId, dto);
		
		// 결과 응답
		return ResponseEntity.status(HttpStatus.OK).body(createDto);
	}
	
	
	// 댓글 수정 요청
	// Talend API Tester(PATCH) => http://localhost:9090/api/comments/1
	@PatchMapping("/api/comments/{id}")
	public ResponseEntity<commentDto> update(@PathVariable Long id, @RequestBody commentDto dto){
		log.info("CommentApiController의 update() 메소드");
		log.info("id: {}", id);
		log.info("dto: {}", dto);
		
		// 서비스에 위임
		commentDto updateDto = commentService.update(id, dto);
		// 결과 응답
		return ResponseEntity.status(HttpStatus.OK).body(updateDto);
	}

	
	// 댓글 삭제 요청
	// Talend API Tester(DELETE) => http://localhost:9090/api/comments/1
	@DeleteMapping("/api/comments/{id}")
	public ResponseEntity<commentDto> delete(@PathVariable Long id) {
		log.info("CommentApiController의 delete() 메소드");
		log.info("id: {}", id);
		
		// 서비스에 위임
		commentDto deleteDto = commentService.delete(id);
		// 결과 응답
		return ResponseEntity.status(HttpStatus.OK).body(deleteDto);
	}
}
