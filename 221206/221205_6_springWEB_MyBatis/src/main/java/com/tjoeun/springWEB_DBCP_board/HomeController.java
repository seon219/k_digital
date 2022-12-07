package com.tjoeun.springWEB_DBCP_board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tjoeun.dao.MyBatisDAO;
import com.tjoeun.service.ContentViewService;
import com.tjoeun.service.DeleteService;
import com.tjoeun.service.IncrementService;
import com.tjoeun.service.InsertService;
import com.tjoeun.service.MvcboardService;
import com.tjoeun.service.ReplyService;
import com.tjoeun.service.SelectService;
import com.tjoeun.service.UpdateService;
import com.tjoeun.vo.MvcboardList;
import com.tjoeun.vo.MvcboardVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 여기부터
//	private JdbcTemplate template;
//	public JdbcTemplate getTemplate() { 
//		return template;
//	}
//	@Autowired
//	public void setTemplate(JdbcTemplate template) { // setter
//		//System.out.println("꺄오~~");
//		this.template = template;
//		Constant.template = this.template;
//	} 
	// 여기까지 mybatis로 변환이 완료되면 주석으로 처리한다.
	
	
	// servlet-context.xml 파일에서 생성한 mybatis bean(sqlSession)을 사용하기 위해서 SqlSession 인터페이스 타입의 객체를 생성한다.
	// servlet-context.xml 파일에서 생성된 mybatis bean을 자동으로 SqlSession 인터페이스 타입의 객체에 넣어주도록 하기 위해서 @Autowired 어노테이션을 붙여준다.
	@Autowired
	private SqlSession sqlSession;
	

	// 프로젝트가 실행되면 최초의 요청("/")을 받아 대문 페이지를 요청한다.
	// 게시판의 대문은 글 목록을 얻어와서 화면에 보여주는 list.jsp를 글 목록을 얻어와서 보여준다.
	@RequestMapping("/")
	public String start(Locale locale, Model model) {
		logger.info("start()");
		return "redirect:list"; // @RequestMapping("/list") 어노테이션이 지정된 메소드를 실행한다.
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
		
		// insert.jsp에서 입력한 데이터가 저장된 HttpServletRequest 인터페이스 객체를 Model 인터페이스
		// 객체에 저장한다.
//		model.addAttribute("request", request);
//		
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		MvcboardService service = ctx.getBean("insert", InsertService.class);
//		service.execute(model);
		
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
		
		// 컨트롤러에 list로 요청하는 페이지에서 넘어오는 브라우저에 표시할 페이지 번호가 저장된 
		// HttpServletRequest 인터페이스 객체를 model 객체에 저장한다.
//		model.addAttribute("request", request);
//		
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		MvcboardService service = ctx.getBean("select", SelectService.class);
//		service.execute(model);
		
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
		
		// 조회수를 증가시킬 글번호가 저장된 HttpServletRequest 인터페이스 객체를 Model 인터페이스 객체에 저장된다.
//		model.addAttribute("request", request);
		
		// 조회수를 증가시키는 메소드를 실행한다.
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		MvcboardService service = ctx.getBean("increment", IncrementService.class);
//		service.execute(model);
		
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
		
		// 조회수를 증가시킨 글 번호와 작업 후 돌아갈 페이지 번호가 저장된 HttpServletRequest 인터페이스 객체를 
		// Model 인터페이스 객체에 저장한다.
//		model.addAttribute("request", request);
		
		// 조회수를 증가시킨 글 1건을 얻어오는 메소드
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		MvcboardService service = ctx.getBean("contentView", ContentViewService.class);
//		service.execute(model);
		
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
		
		// 수정할 글번호와 데이터(제목, 내용), 수정 후 돌아갈 페이지 번호가 저장된 
		// HttpServletRequest 인터페이스 객체를 Model 인터페이스 객체에 저장한다.
//		model.addAttribute("request", request);
		
		// 글 1건을 수정하는 메소드를 실행
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		MvcboardService service = ctx.getBean("update", UpdateService.class);
//		service.execute(model);
		
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
		
		// 삭제할 글 번호와 삭제 후 돌아갈 페이지 번호가 저장된 
		// HttpServletRequest 인터페이스 각체를 Model 인터페이스 객체를 지정한다.
//		model.addAttribute("request", request);
		
		
		// 글 1건을 삭제하는 메소드를 실행
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		MvcboardService service = ctx.getBean("delete", DeleteService.class);
//		service.execute(model);
		
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
		
		// 답변을 입력할 원본 글의 글번호와 작업 후 돌아갈 페이지 번호가 저장된 
		// HttpServletRequest 인터페이스 객체를 Model 인터페이스 객체에 넣어준다.
//		model.addAttribute("request", request);
		
		// 답변을 입력할 글 1건을 얻어오는 메소드를 실행한다.
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		MvcboardService service = ctx.getBean("contentView", ContentViewService.class);
//		service.execute(model);
		
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
		
		// 원본 글번호, 글 그룹, 글 레벨, 같은 글 그룹에서 글 출력 순서, 답글 작성자 이름, 답글 제목,
		// 답글 내용, 답글을 저장하고 돌아갈 페이지 번호가 저장된 HttpServletRequest 인터페이시 객체를 
		// Model 인터페이스 객체에 저장한다.
//		model.addAttribute("request", request);
		
		// 답글을 위치에 맞게 삽입하는 메소드를 실행한다.
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		MvcboardService service = ctx.getBean("reply", ReplyService.class);
//		service.execute(model);
		
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