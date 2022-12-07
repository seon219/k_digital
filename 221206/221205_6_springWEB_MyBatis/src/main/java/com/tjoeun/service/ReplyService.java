package com.tjoeun.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.tjoeun.dao.MvcboardDAO;
import com.tjoeun.vo.MvcboardVO;

public class ReplyService implements MvcboardService {

	private static final Logger logger = LoggerFactory.getLogger(InsertService.class);

	@Override
	public void execute(MvcboardVO mvcboardVO) { }
	

	@Override
	public void execute(Model model) {
		logger.info("execute()");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		
		// Model 인터페이스 객체에 저장되서 넘어온 HttpServletRequest 인테페이스 객체에서 원본 글 번호, 
		// 글 그룹, 글 레벨, 같은 글 그룹에서 글 출력순서, 답글 작성자 이름, 답글 제목, 답글 내용을 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		int gup = Integer.parseInt(request.getParameter("gup"));
		int lev = Integer.parseInt(request.getParameter("lev"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardDAO mvcboardDAO = ctx.getBean("mvcboardDAO", MvcboardDAO.class);
		
		//HttpServletRequest 인터페이스 객체에서 받은 데이터를 MvcboardVO 클래스의 bean을 넣어준다,
		MvcboardVO mvcboardVO = ctx.getBean("mvcboardVO", MvcboardVO.class);
		mvcboardVO.setIdx(idx);
		mvcboardVO.setName(name);
		mvcboardVO.setSubject(subject);
		mvcboardVO.setContent(content);
		mvcboardVO.setGup(gup);
		// 답글은 질문글 바로 아래 위치해야 하므로 lev와 seq를 1씩 증가시켜서 넣어준다.
		mvcboardVO.setLev(lev + 1);
		mvcboardVO.setSeq(seq + 1);
		
		// 댓글이 삽입될 위치를 정하기 위해 조건에 만족하는 seq를 1씩 증가시키는 메소드
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("gup", mvcboardVO.getGup());
		hmap.put("seq", mvcboardVO.getSeq());
		mvcboardDAO.replyInsert(hmap);
		
		// 답글을 저장하는 메소드를 실행
		mvcboardDAO.replyInsert(mvcboardVO);
		
		// 답글 저장 후 돌아갈 페이지 번호를 Model 인터페이스 객체에 저장
		model.addAttribute("currentPage", request.getParameter("currentPage"));
		
	}

}
