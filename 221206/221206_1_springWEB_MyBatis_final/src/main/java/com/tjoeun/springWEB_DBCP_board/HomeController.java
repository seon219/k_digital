package com.tjoeun.springWEB_DBCP_board;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjoeun.dao.MyBatisDAO;
import com.tjoeun.vo.MvcboardList;
import com.tjoeun.vo.MvcboardVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	

	// 게시판의 대문은 글 목록을 얻어와서 화면에 보여주는 list.jsp를 글 목록을 얻어와서 보여준다.
	@RequestMapping("/")
	public String start(Locale locale, Model model) {
		logger.info("start()");
		return "redirect:list";
	}
	
	// 글 입력 폼(insert.jsp)를 호출하는 메소드
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, Model model) {
		logger.info("insert()");
		return "insert";
	}
	
	
	// 글 입력 폼에 입력된 내용을 테이블에 저장하는 메소드 => Model 인터페이스 객체 사용
	@RequestMapping("/insertOK")
	public String insertOK(HttpServletRequest request, Model model, MvcboardVO mvcboardVO) {
		logger.info("insertOK() - 커맨드 인터페이스 객체 사용");
		logger.info("{}", mvcboardVO);
		
		// mapper로 사용할 인터페이스 객체에 mybatis mapper를 붙여서 사용
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 메인글을 저장하는 insert sql 명령을 실행
		mapper.insert(mvcboardVO);
		
		return "redirect:list";
	}
	
	
	// 브라우저에 출력할 1페이지 분량의 글 목록을 얻어오고 1페이지 분량의 글 목록을 출력하는 페이지를 호출하는 메소드
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		logger.info("list()");
		
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 한 페이지에 표시할 글의 개수, 브라우저에 표시할 페이지 번호, 전체 글의 개수를 저장
		int pageSize = 10;
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (NumberFormatException e) { }
		int totalCount = mapper.selectCount();
		
		
		// 1페이지 분량의 글과 페이징 작업에 사용할 변수를 초기화시킨다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardList mvcboardList = ctx.getBean("mvcboardList", MvcboardList.class);
		mvcboardList.initMvcboardList(pageSize, totalCount, currentPage);
		
		// 1페이지 분량의 글 목록을 얻어온다.
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startNo", mvcboardList.getStartNo());
		hmap.put("endNo", mvcboardList.getEndNo());
		mvcboardList.setList(mapper.selectList(hmap));
		
		// list.jsp로 넘겨줄 데이터를 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("boardList", mvcboardList);
		
		return "list";
	}
	
	
	// 조회수를 증가시키는 메소드
	@RequestMapping("/increment")
	public String increment(HttpServletRequest request, Model model) {
		logger.info("increment()");
		logger.info("idx: {}, currentPage: {}", request.getParameter("idx"), request.getParameter("currentPage"));
		
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 조회수를 증가시킬 글 번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 조회수를 증가시키는 메소드를 실행한다.
		mapper.increment(idx);
		
		// 조회수를 증가시킨 브라우저에 표시할 글 번호와 작업 후 돌아갈 페이지 번호를 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("idx", request.getParameter("idx"));
		model.addAttribute("currentPage", request.getParameter("currentPage"));
		
		return "redirect:contentView";
	}
	
	
	// 조회수를 증가시킨 글 1건을 브라우저에 출력하기 위해서 테이블에서 얻어오는 메소드
	@RequestMapping("/contentView")
	public String contentView(HttpServletRequest request, Model model) {
		logger.info("contentView()");
		logger.info("idx: {}, currentPage: {}", request.getParameter("idx"), request.getParameter("currentPage"));
		
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 조회수를 증가시킨(화면에 표시할) 글 번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 조회수를 증가시킨 글 1건을 얻어와서 MvcboardVo 클래스 객체에 저장
		MvcboardVO mvcboardVO = mapper.selectByIdx(idx);
		
		// 브라우저에 출력할 글, 작업 후 들어갈 페이지 번호, 줄바꿈에 사용할 "/r/n"을 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("vo", mvcboardVO);
		model.addAttribute("currentPage", request.getParameter("currentPage"));
		model.addAttribute("enter", "/r/n");
		
		return "contentView";
	}
	
	
	// 글 1건을 수정하는 메소드
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model, MvcboardVO mvcboardVO) {
		logger.info("update()");
		
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 글을 수정하는 메소드를 실행
		mapper.update(mvcboardVO);
		
		// 글 수정 작업 후 돌아갈 페이지 번호를 Model 인터페이스 객체에 저장
		model.addAttribute("currentPage", request.getParameter("currentPage"));
		
		return "redirect:list";
	}
	
	
	// 글 1건을 삭제하는 메소드
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		logger.info("delete()");
		
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 삭제할 글 번호를 받는다. 
		int idx = Integer.parseInt(request.getParameter("idx"));
		// 글을 삭제하는 메소드를 실행
		mapper.delete(idx);
		// 글 삭제 작업 후 돌아갈 페이지 번호를 Model 인터페이스 객체에 저장
		model.addAttribute("currentPage", request.getParameter("currentPage"));
		
		return "redirect:list";
	}
	
	
	// 답글을 입력하기 위해 브라우저에 출력할 메인글을 얻어오고 답글을 입력하는 페이지를 호출하는 메소드
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		logger.info("reply()");
		
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 답글을 입력할 글 번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		// 답글을 입력할 글 1건을 얻어와서 MvcboardVo 클래스 객체에 저장
		MvcboardVO mvcboardVO = mapper.selectByIdx(idx);
		
		// 브라우저에 출력할 글, 작업 후 들어갈 페이지 번호, 줄바꿈에 사용할 "/r/n"을 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("vo", mvcboardVO);
		model.addAttribute("currentPage", request.getParameter("currentPage"));
		model.addAttribute("enter", "/r/n");
		
		return "reply";
	}
	
	
	// 답글을 위치에 맞게 삽입하는 메소드
	@RequestMapping("/replyInsert")
	public String replyInsert(HttpServletRequest request, Model model, MvcboardVO mvcboardVO) {
		logger.info("replyInsert()");
		
		// mapper를 얻어온다.
		MyBatisDAO mapper = sqlSession.getMapper(MyBatisDAO.class);
		
		// 커맨드 객체를 이용해서 답글 내용을 받았으면 lev와 seq는 1씩 증가시켜야 한다.
		mvcboardVO.setLev(mvcboardVO.getLev() + 1);
		mvcboardVO.setSeq(mvcboardVO.getSeq() + 1);
		
		// 답글이 삽입될 위치를 정하기 위해 조건에 만족하는 seq을 1씩 증가시키는 메소드
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("gup", mvcboardVO.getGup());
		hmap.put("seq", mvcboardVO.getSeq());
		mapper.replyIncrement(hmap);
		
		// 답글을 저장하는 메소드를 실행
		mapper.replyInsert(mvcboardVO);
		
		// 답글 저장 후 돌아갈 페이지 번호를 Model 인터페이스 객체에 저장
		model.addAttribute("currentPage", request.getParameter("currentPage"));
		
		return "redirect:list";
	}
}