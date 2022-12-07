package com.tjoeun.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.tjoeun.dao.MvcboardDAO;
import com.tjoeun.vo.MvcboardVO;

public class ContentViewService implements MvcboardService {

	private static final Logger logger = LoggerFactory.getLogger(InsertService.class);

	@Override
	public void execute(MvcboardVO mvcboardVO) { }

	@Override
	public void execute(Model model) {
		logger.info("execute()");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// Model 인터페이스 객체에 저장되서 넘어온 HttpServletRequest 인터페이스 객체에서 조회수를 증가시킨 글번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 조회수를 증가시킨 글 1건을 얻어오는 메소드를 실행해서 얻어온 글을 MvcboardVo 클래스 객체에 저장
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardDAO mvcboardDAO = ctx.getBean("mvcboardDAO", MvcboardDAO.class);
		MvcboardVO mvcboardVO = ctx.getBean("mvcboardVO", MvcboardVO.class);
		mvcboardVO = mvcboardDAO.selectByIdx(idx);
		logger.info("{}", mvcboardVO);
		
		// 브라우저에 출력할 글, 작업 후 들어갈 페이지 번호, 줄바꿈에 사용할 "/r/n"을 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("vo", mvcboardVO);
		model.addAttribute("currentPage", request.getParameter("currentPage"));
		model.addAttribute("enter", "/r/n");
	}

}
