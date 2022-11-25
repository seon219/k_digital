package com.tjoeun.springDI_xml_constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		xml 파일에 설정된 정보로 bean을 만든다. => 생성자가 실행된다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student = ctx.getBean("student", Student.class);
		System.out.println(student);
		
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		System.out.println(studentInfo);
		studentInfo.getStudentInfo();
		
	}
	
}
