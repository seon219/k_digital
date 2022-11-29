package com.tjoeun.springWEB_request;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/memberView")
	// HttpServletRequest 인터페이스 객체로 뷰 페이지에서 컨트롤러로 넘어오는 데이터를 받는다.
	// Model 인터페이스 객체에 컨트롤러에서 뷰 페이지로 넘겨줄 데이터를 저장한다.
	public String memberView(HttpServletRequest request, Model model) {
		logger.info("memberView()");
		
		// 뷰 페이지에서 get 방식으로 컨트롤러로 넘어와 HttpServletRequest 인터페이스 객체에 저장되는 데이터를 받는다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//logger.info("id: " + id + ", pw: " + pw);
		logger.info("id: {}, pw: {}", id, pw);
		
		// 컨트롤러에서 뷰 페이지로 넘겨줄 데이터를 Model 인터페이스 객체에 저장한다.
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "memberView";
	}
	
	
	@RequestMapping("/memberLogin")
	// @RequestParam("뷰 페이지에서 컨트롤러로 넘어오는 변수명") 자료형 변수명
	// @RequestParam("id") String id 는 request.getParameter("id");와 같은 기능을 실행한다.
	
	// HttpServletRequest 인터페이스 객체로 뷰 페이지에서 컨트롤러로 넘어오는 데이터를 받을 때 데이터가 넘어오지 않고 null로 처리되지만
	// @RequestParam 어노테이션을 사용해서 뷰 페이지에서 넘어오는 데이터를 받을 때 데이터가 넘어오지 않으면 400 - Bad Request 에러가 발생된다.
	public String memberLogin(/* HttpServletRequest request, */ Model model, 
			@RequestParam("id") String id,
			@RequestParam("pw") String pw
			) {
		logger.info("memberLogin()");
		
		//String id = request.getParameter("id");
		//String pw = request.getParameter("pw");
		logger.info("id: {}, pw: {}", id, pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "memberLogin";
	}
	
	
	@RequestMapping("/member")
	public String member(HttpServletRequest request, Model model) {
		logger.info("member()");
		return "member";
	}
	
	
	
	@RequestMapping("/memberInsert")
	public String memberInsert( HttpServletRequest request, Model model) {
		logger.info("memberInsert()");
		
		// 뷰 페이지에서 컨트롤러로 넘어와 HttpServletRequest 인터페이스 타입의 객체에 저장된 데이터를 받는다.
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		// 기본생성자로 vo 클래스 객체를 만들고 setter 메소드로 데이터를 넣어준다.
		/*
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setId(id);
		vo.setpassword(password);
		vo.setEmail(email);
		*/
		
		// public MemberVO(String name, String id, String pw, String email) 생성자를 사용해서 넘겨받은 데이터를 넣어준다.
		MemberVO vo = new MemberVO(name, id, password, email);
		System.out.println(vo);
		
		return "memberInsert";
	}
	
}
