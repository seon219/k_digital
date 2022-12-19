package com.tjoeun.firstproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.utility.nullability.MaybeNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comment {

	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 시퀀스를 DB가 자동으로 증가시킨다.
	private Long id;
	@Column
	private String nickname;
	@Column
	private String body;
	
	@ManyToOne // 댓글 entity(Comment) 여러개가 하나의 메인글(Article)에 연관된다.
	@JoinColumn(name = "article_id") // article_id 컬럼에 Article의 대표값(기본키)을 저장한
	private Article article;
	
}
