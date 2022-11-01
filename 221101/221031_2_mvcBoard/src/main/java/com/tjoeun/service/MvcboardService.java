package com.tjoeun.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.tjoeun.dao.MvcBoardDAO;
import com.tjoeun.mybatis.MySession;
import com.tjoeun.vo.MvcBoardList;
import com.tjoeun.vo.MvcBoardVO;

public class MvcboardService {

	private static MvcboardService instance = new MvcboardService();
	private MvcboardService() {}
	public static MvcboardService getInstance() {
		return instance;
	}
	
	private MvcBoardDAO dao = MvcBoardDAO.getInstance();
	
	// 컨트롤러에 insertOK.nhn이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 테이블에 저장할 메인글이 저장된
	// request 객체를 넘겨받고 mapper를 얻어온 후 MvcBoardDAO 클래스의 insert sql 명령을 실행하는 메소드를 호출하는 메소드
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService의 insert()");
		SqlSession mapper = MySession.getSession();

		// insert.jsp에서 입력한 request 객체에 저장되서 넘어오는 데이터를 받아서 MvcBoardVO 클래스 객체에 저장
		MvcBoardVO vo = new MvcBoardVO();
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		System.out.println(vo);
		
		//MvcBoardDAO 클래스에 insert.jsp에서 입력한 데이터를 테이블에 저장하는 insert sql 명령을 실행하는 메소드를 호출
		dao.insert(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
	
	// 컨트롤러에 list.nhn이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 mapper를 얻어온 후
	// MvcBoardDAO 클래스의 브라우저에 출력할 1페이지 분량의 글 목록과 페이징 작업에 사용할 8개의 변수가 저장된
	// 클래스의 객체를 만들어 request 영역에 저장하는 메소드를 호출하는 메소드
	public void selectList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService의 selectList()");
		SqlSession mapper = MySession.getSession();
		
		// list.nhn이 요청될 때 넘어오는 브라우저에 표시할 페이지 번호를 받는다.
		// 브라우저에 표시할 페이지 번호가 정상적으로 넘어왔으면 넘어온 페이지 번호로, 
		//  정상적으로 넘어오지 않았다면 1로 브라우저에 표시할 페이지 번호를 설정한다.
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch(NumberFormatException e) {
			
		}
		
		// 1페이지에 표시할 글의 개수를 정한다.
		int pageSize = 10;
		// 테이블에 저장된 전체 글의 개수를 얻어온다.
		int totalCount = dao.selectCount(mapper);
		System.out.println(totalCount);
		
		// 1페이지 분량의 글과 페이징 작업에 사용되는 8개의 변수를 초기화시키는 MvcBoartdList 클래스의 객체를 만든다.
		MvcBoardList boardList = new MvcBoardList(pageSize, totalCount, currentPage);
		// 1페이지 분량의 시작, 끝 인덱스를 기억하는 HashMap 객체를 만들고 초기화
		HashMap<String, Integer> hmap = new HashMap<>();
		hmap.put("startNo", boardList.getStartNo());
		hmap.put("endNo", boardList.getEndNo());
		// 1페이지 분량의 글 목록을 얻어와서 boardList의 ArrayList에 넣어준다.
		boardList.setList(dao.selectList(mapper, hmap));
		System.out.println(boardList.getList());
		
		// MvcBoardList 클래스 객체를 request 영역에 저장
		request.setAttribute("boardList", boardList);
		
		mapper.commit();
		mapper.close();
	}
	
	
	// 컨트롤러에 increment.nhn이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 조회수를 증가시킬 글 번호를 넘겨받고
	// mapper를 얻어온 후 MvcBoardDAO 클래스의 update sql 명령을 실행나는 메소드를 호출하는 메소드
	public void increment(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService의 increment()");
		SqlSession mapper = MySession.getSession();
		
		// request 객체로 넘어오는 조회수를 증가시킬 글번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 조회수를 증가시키는 메소드를 호출한다.
		dao.increment(mapper, idx);
		
		mapper.commit();
		mapper.close();
	}
	
	
	// 컨트롤러에 contentView.nhn이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 조회수를 증가시킨 
	// 글 번호를 넘겨받고 mapper를 얻어온 후 MvcBoardDAO 클래스의 update sql 명령을 실행하고 
	// 얻어온 조회수를 증가시킨 글 1건을 request 영역에 저장하는 메소드
	public void selectByIdx(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService의 selectByIdx()");
		SqlSession mapper = MySession.getSession();
		
		// request 객체로 넘어오는 조회수를 증가시킨 글 번호와 돌아갈 페이지 번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		// 조회수를 증가시킨 글 1건을 얻어와서 MvcBoardVO 클래스 객체에 저장
		MvcBoardVO vo = dao.selectByIdx(mapper, idx);
		//System.out.println(vo);
		
		// 브라우저에 표시할 글이 저장된 객체(vo), 작업 후 돌아갈 페이지 번호(currentPage), 
		// 줄바꿈에 이스케이프 시퀀스(\r\n)를 request 영역에 저장
		request.setAttribute("vo", vo);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("enter", "\r\n");
		
		mapper.commit();
		mapper.close();
	}
	
	
	// 컨트롤러에 update.nhn이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 수정할 정보가 저장된
	// request 객체를 넘겨받고 mapper를 얻어온 후 MvcBoardDAO 클래스의 update sql 명령을 실행하는 메소드를 실행하는 메소드
	public void update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService의 update()");
		SqlSession mapper = MySession.getSession();
		
		// request 객체로 넘어오는 수정할 데이터를 받아서 MvcBoardVO 클래스 객체에 저장
		MvcBoardVO vo = new MvcBoardVO();
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		//System.out.println(vo);
		
		// 글 1건을 수정하는 메소드를 호출
		dao.update(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
	
	// 컨트롤러에 delete.nhn이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 삭제할 정보가 저장된
	// request 객체를 넘겨받고 mapper를 얻어온 후 MvcBoardDAO 클래스의 delete sql 명령을 실행하는 메소드를 실행하는 메소드
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService의 delete()");
		SqlSession mapper = MySession.getSession();
		
		
		// request 객체로 넘어오는 삭제할 글번호를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		//int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		// 글 1건을 삭제하는 메소드를 호출
		dao.delete(mapper, idx);
		
		
		mapper.commit();
		mapper.close();
	}
	
	// 컨트롤러에 replyInsert.nhn이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 
	// 답글 정보를 넘겨받고 mapper를 얻어온 후 MvcBoardDAO 클래스의 조건에 만족하는 seq를 1씩 증가시키는
	// update sql 명령을 실행하고 답글을 저장하는 메소드를 실행하는 메소드
	public void replyInsert(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService의 replyInsert()");
		SqlSession mapper = MySession.getSession();
		
		// request 객체로 넘어오는 답글 정보를 받는다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		int gup = Integer.parseInt(request.getParameter("gup"));
		int lev = Integer.parseInt(request.getParameter("lev"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// 넘겨받은 답글 정보를 MvcBoardVO 클래스 객체에 저장한다.
		// 이 때, lev와 seq는 1씩 증가시켜 저장한다.
		MvcBoardVO vo = new MvcBoardVO();
		vo.setIdx(idx);
		vo.setGup(gup);
		vo.setLev(lev + 1);
		vo.setSeq(seq + 1);
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		
		// 같은 글 그룹(gup)에서 답글이 표시될 위치(seq) 이후의 모든 글이 출력될 위치를 1씩 증가시키는 메소드 실행
		HashMap<String, Integer> hmap = new HashMap<>();
		hmap.put("gup", vo.getGup());
		hmap.put("seq", vo.getSeq());
		dao.incrementSeq(mapper, hmap);
		
		// 답글을 저장하는 메소드를 실행
		dao.replyInsert(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
	
}
