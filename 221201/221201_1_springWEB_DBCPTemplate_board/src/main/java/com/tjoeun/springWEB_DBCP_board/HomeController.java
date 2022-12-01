package com.tjoeun.springWEB_DBCP_board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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

import com.tjoeun.service.ContentViewService;
import com.tjoeun.service.DeleteService;
import com.tjoeun.service.IncrementService;
import com.tjoeun.service.InsertService;
import com.tjoeun.service.MvcboardService;
import com.tjoeun.service.ReplyService;
import com.tjoeun.service.SelectService;
import com.tjoeun.service.UpdateService;
import com.tjoeun.vo.MvcboardVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// JdbcTemplate을 사용하려면 servlet-context.xml 파일에서 프로젝트가 실행될 때 
	// DriverManagerDataSource 클래스의 bean(데이터베이스 연결 정보)을 참조해서 생성한  
	// JdbcTemplate 클래스의 bean을 컨트롤러에서 JdbcTemplate 클래스 타입의 객체를 생성하고 넣어줘야 한다.
	private JdbcTemplate template;
	

	// JdbcTemplate 클래스 타입 객체의 getter & setter를 만든다. => getter은 안 만들어오 됨
	public JdbcTemplate getTemplate() { 
		return template;
	}
	
	
	// 프로젝트를 실행하면 스프링 환경설정파일은 servlet-context.xml 파일이 읽혀진 다음 
	// JdbcTemplate 클래스 객체의 setter 메소드가 자동으로 실행되게 하기 위해서 @Autowired 어노테이션을 붙여준다.
	
	// @Autowired을 붙여준 메소드는 서버가 구동되는 단계에서 자동으로 실행되며 setter의 인수 template으로 
	// 스프링이 알아서 servlet-context.xml 파일에서 생성한 JdbcTemplate 클래스의 bean을 자동으로 전달한다.

	// setter 메소드는 자동으로 전달받은 JdbcTemplate 클래스의 bean으로 JdbcTemplate 클래스 객체를 초기화 시킨다.
	@Autowired
	public void setTemplate(JdbcTemplate template) { // setter
		System.out.println("꺄오~~");
		this.template = template;
		
		// 여기까지 정상적으로 실행되면 컨트롤러에서 JdbcTemplate을 사용할 수 있게 된다.
		// 데이터 베이스 연결은 주로 DAO 클래스에서 하므로 컨트롤러 이외의 클래스에서 JdbcTemplate을 사용할 수 있게 하기 위해서
		// 적당한 이름의 패키지(base-pakage)에 적당한 이름의 클래스(Constant)를 만들고 적당한 이름으로 작성한 클래스의 
		// 정적 필드(public static JdbcTemplate template)에 servlet-context.xml 파일에서 생성된 JdbcTemplate 클래스의 bean을 넣어준다.
		
		// 적당한 이름으로 클래스를 만들고 JdbcTemplate 객체를 static으로 선언한 후 코딩한다.
		Constant.template = this.template;
		
	} 

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
	public String insertOK(HttpServletRequest request, Model model) {
		logger.info("insertOK() - Model 인터페이스 객체 사용");
		
		// insert.jsp에서 입력한 데이터가 저장된 HttpServletRequest 인터페이스 객체를 Model 인터페이스
		// 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("insert", InsertService.class);
		service.execute(model);
		
		return "redirect:list";
	}
	
	
	// 브라우저에 출력할 1페이지 분량의 글 목록을 얻어오고 1페이지 분량의 글 목록을 출력하는 페이지를 호출하는 메소드
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		logger.info("list()");
		
		// 컨트롤러에 list로 요청하는 페이지에서 넘어오는 브라우저에 표시할 페이지 번호가 저장된 
		// HttpServletRequest 인터페이스 객체를 model 객체에 저장한다.
		model.addAttribute("request", request);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("select", SelectService.class);
		service.execute(model);
		
		return "list";
	}
	
	
	// 조회수를 증가시키는 메소드
	@RequestMapping("/increment")
	public String increment(HttpServletRequest request, Model model) {
		logger.info("increment()");
		logger.info("idx: {}, currentPage: {}", request.getParameter("idx"), request.getParameter("currentPage"));
		
		// 조회수를 증가시킬 글번호가 저장된 HttpServletRequest 인터페이스 객체를 Model 인터페이스 객체에 저장된다.
		model.addAttribute("request", request);
		
		// 조회수를 증가시키는 메소드를 실행한다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("increment", IncrementService.class);
		service.execute(model);
		
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
		model.addAttribute("request", request);
		
		// 조회수를 증가시킨 글 1건을 얻어오는 메소드
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("contentView", ContentViewService.class);
		service.execute(model);
		
		return "contentView";
	}
	
	
	// 글 1건을 수정하는 메소드
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		logger.info("update()");
		
		// 수정할 글번호와 데이터(제목, 내용), 수정 후 돌아갈 페이지 번호가 저장된 
		// HttpServletRequest 인터페이스 객체를 Model 인터페이스 객체에 저장한다.
		model.addAttribute("request", request);
		
		// 글 1건을 수정하는 메소드를 실행
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("update", UpdateService.class);
		service.execute(model);
		
		return "redirect:list";
	}
	
	
	// 글 1건을 삭제하는 메소드
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		logger.info("delete()");
		
		// 삭제할 글 번호와 삭제 후 돌아갈 페이지 번호가 저장된 
		// HttpServletRequest 인터페이스 각체를 Model 인터페이스 객체를 지정한다.
		model.addAttribute("request", request);
		
		
		// 글 1건을 삭제하는 메소드를 실행
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("delete", DeleteService.class);
		service.execute(model);
		
		return "redirect:list";
	}
	
	
	// 답글을 입력하기 위해 브라우저에 출력할 메인글을 얻어오고 답글을 입력하는 페이지를 호출하는 메소드
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		logger.info("reply()");
		
		// 답변을 입력할 원본 글의 글번호와 작업 후 돌아갈 페이지 번호가 저장된 
		// HttpServletRequest 인터페이스 객체를 Model 인터페이스 객체에 넣어준다.
		model.addAttribute("request", request);
		
		// 답변을 입력할 글 1건을 얻어오는 메소드를 실행한다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("contentView", ContentViewService.class);
		service.execute(model);
		
		return "reply";
	}
	
	
	// 답글을 위치에 맞게 삽입하는 메소드
	@RequestMapping("/replyInsert")
	public String replyInsert(HttpServletRequest request, Model model) {
		logger.info("replyInsert()");
		
		// 원본 글번호, 글 그룹, 글 레벨, 같은 글 그룹에서 글 출력 순서, 답글 작성자 이름, 답글 제목,
		// 답글 내용, 답글을 저장하고 돌아갈 페이지 번호가 저장된 HttpServletRequest 인터페이시 객체를 
		// Model 인터페이스 객체에 저장한다.
		model.addAttribute("request", request);
		
		// 답글을 위치에 맞게 삽입하는 메소드를 실행한다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MvcboardService service = ctx.getBean("reply", ReplyService.class);
		service.execute(model);
		
		return "redirect:list";
	}
}