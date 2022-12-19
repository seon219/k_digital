package com.tjoeun.firstproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.firstproject.dto.commentDto;
import com.tjoeun.firstproject.entity.Comment;
import com.tjoeun.firstproject.repository.ArticleRepository;
import com.tjoeun.firstproject.repository.CommentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentService {

	// ArticleRepository와 CommentRepository의 메소드를 사용하기 위해서 @Autowired 어노테이션을 붙여서 
	// ArticleRepository와 CommentRepository의 bean을 가져온다. 
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	// 댓글 목록 조회 실행
	public List<commentDto> comments(Long articleId) {
		log.info("commentService의 comments() 메소드");
		log.info("articleId: {}", articleId);
		
		// 댓글 목록 조회
		List<Comment> comments = commentRepository.findByArticleId(articleId);
		log.info("commnts: {}", comments);
		
		// entity를 dto로 변환
		List<commentDto> dtos = new ArrayList<commentDto>();
		/*
		for (int i = 0; i < comments.size(); i++) {
			Comment comment = comments.get(i);
			// entity를 dto로 변환하는 메소드를 호출한다.
			commentDto dto = commentDto.createCommentDto(comment);
			dtos.add(dto);
		}
		*/
		
		for (Comment comment : comments ) {
			commentDto dto = commentDto.createCommentDto(comment);
			dtos.add(dto);
		}
		
		log.info("dtos: {}", dtos);
		
		// entity를 dto로 변환한 결과를 반환한다.
		return dtos;
	}
	
}
