package com.tjoeun.firstproject.dto;

import com.tjoeun.firstproject.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class commentDto {

	private Long id;
	private String nicknake;
	private String body;
	private Long articleId;
	
	// entity를 dto로 변환하는 메소드
	public static commentDto createCommentDto(Comment comment) {
		return new commentDto(comment.getId(), comment.getNickname(), comment.getBody(), comment.getArticle().getId());
	}
}
