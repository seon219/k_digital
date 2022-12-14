package com.tjoeun.firstproject.dto;

import com.tjoeun.firstproject.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본 생성자 자동 완성
@AllArgsConstructor // 모든 변수를 사용하는 생성자 자동 완성
@Getter // getter 메소드
@Setter // setter 메소드
@ToString // toStirng() 메소드 자동 완성
@EqualsAndHashCode // equals() 메소드와 hashcode() 메소드 자동 완성
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode 자동 완성
public class ArticleForm {
	
	private Long id; // id 필드 추가
	private String title;
	private String content;
	
	/*
	public ArticleForm() { }
	public ArticleForm(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "ArticleForm [title=" + title + ", content=" + content + "]";
	}
	*/
	
	// DTO 클래스의 데이터를 Entity로 변환하는 메소드를 추가한다.
	public Article toEntity() {
		/* return new Article(null, title, content); */
		// 추가된 id 필드로 Entity 객체를 초기화 할 수 있도록 수정
		return new Article(id, title, content);
	}
}
