package com.tjoeun.firstproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.firstproject.dto.commentDto;
import com.tjoeun.firstproject.entity.Article;
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
		
		/*
		for (Comment comment : comments ) {
			commentDto dto = commentDto.createCommentDto(comment);
			dtos.add(dto);
		}
		
		log.info("dtos: {}", dtos);
		
		// entity를 dto로 변환한 결과를 반환한다.
		return dtos;
		*/
		
		// stream
		return commentRepository.findByArticleId(articleId)
				.stream()
				.map(comment -> commentDto.createCommentDto(comment))
				.collect(Collectors.toList());
	}

	
	// 댓글 생성 실행
	// 댓글 생성에 실패하면 실행 전 상태로 되돌려야 하므로 트랜잭션 처리를 해야 한다.
	@Transactional
	public commentDto create(Long articleId, commentDto dto) {
		log.info("commentService의 create() 메소드");
		log.info("articleId: {}", articleId);
		log.info("dto: {}", dto);
		
		// 게시글 조회 및 예외 발생
		// 댓글을 저장하려는 메인글이 있으면 얻어오고 없으면 예외를 발생시킨다.
		//Article article = articleRepository.findById(articleId).orElse(null);
		Article article = articleRepository.findById(articleId).orElseThrow(
				() -> new IllegalArgumentException("댓글 생성 실패! 메인글이 없습니다.")
			);
		
		// 댓글 entity를 생성
		// dto를 entity로 변환하는 메소드를 호출
		Comment comment = Comment.createComment(dto, article);
		// 댓글 entity를 DB에 저장
		Comment created = commentRepository.save(comment);
		// dto로 변환해서 리턴
		return commentDto.createCommentDto(created);
		
	}


	// 댓글 수정 실행
	// 댓글 수정에 실패하면 실행 전 상태로 되돌려야 하므로 트랜잭션 처리를 해야 한다.
	@Transactional
	public commentDto update(Long id, commentDto dto) {
		log.info("commentService의 update() 메소드");
		log.info("id: {}", id);
		log.info("dto: {}", dto);
		
		// 게시글 조회 및 예외 발생
		// 수정하려는 댓글이 있으면 얻어오고 없으면 예외를 발생시킨다.
		Comment comment = commentRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("댓글 생성 실패! 수정할 댓글이 없습니다.")
			);
		
		// 댓글 수정, 댓글을 수정하는 메소드를 호출한다.
		comment.patch(dto);
		// 수정된 댓글로 DB를 갱신한다.
		Comment updated = commentRepository.save(comment);
		// 댓글 entity를 dto로 변환 및 반환
		return commentDto.createCommentDto(updated);
	}


	// 댓글 삭제 실행
	// 댓글 삭제에 실패하면 실행 전 상태로 되돌려야 하므로 트랜젝션 처리를 해야한다.
	@Transactional
	public commentDto delete(Long id) {
		log.info("commentService의 delete() 메소드");
		log.info("id: {}", id);
		
		// 게시글 조회 및 예외 발생
		// 수정하려는 댓글이 있으면 얻어오고 없으면 예외를 발생시킨다.
		Comment comment = commentRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("댓글 생성 실패! id에 해당되는 댓글이 없습니다.")
			);
		
		// 댓글 삭제
		commentRepository.delete(comment);
		// 삭제한 댓글 entity를 dto로 변환 및 반환
		return commentDto.createCommentDto(comment);
	}
	
	
	
}
