package com.tjoeun.firstproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 어노테이션을 필수로 붙여야 하고 엔티티라 부른다.
// @Entity 어노테이션이 붙은 클래스 이름으로 SpringBoot가 자동으로 테이블을 만들고 
// 클래스 내부에 선언한 필드 이름으로 테이블을 구성하는 컬럼을 만들어준다.

@Entity // 현재 클래스는 Entity로 사용되는 클래스임을 의미한다.
public class Article {

	// 기본키로 사용할 필드 선언
	// 기본키를 자동으로 생성하려면 @Id와 @GeneratedValue 어노테이션을 함께 사용해야 한다.
	@Id // 필드를 기본키로 설정한다.
	@GeneratedValue // 기본키 값을 자동으로 생성
	private Long id;
	
	@Column // 필드를 테이블 컬럼과 매핑한다.
	private String title;
	
	@Column
	private String content;
	
	public Article() { }
	public Article(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
}
