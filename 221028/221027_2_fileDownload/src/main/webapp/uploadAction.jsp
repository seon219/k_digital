<%@page import="javax.tools.DocumentationTool.Location"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
	
		MultipartRequest mr = new MultipartRequest(
									request, 							// 요청 객체
									application.getRealPath("/upload"), // 파일이 업로도 될 실제 경로
									5 * 1024 * 1024 * 1024, 			// 업로드 할 파일의 최대 크기를 바이트 단위로 지정 => 5GB
									"UTF-8", 							// 문자 인코딩 방식
									new DefaultFileRenamePolicy()		// 업로드 되는 파일과 같은 이름의 파일이 존재할 경우 이름을 자동으로 변경해주는 객체
		);		
		
		
		// getOriginalFileName(): 사용자가 업로드한 파일 이름을 얻어옴
		String filename = mr.getOriginalFileName("file");
		// getFilesystemName(): 업로드되서 실제 디스크에 저장된 파일 이름을 얻어온다.
		String fileRealname = mr.getFilesystemName("file");
		File realFile = mr.getFile("file");
		// length(): 파일의 크기를 얻어온다.
		long fileLength = realFile.length();
		
		// 업로드 제한
		out.println("<script>");
		if (fileLength > 5 * 1024 * 1024) {
			
			out.println("alert('현재 파일의 크기는 " + fileLength + "입니다. \\n5,242,880 바이트까지 업로드 가능합니다.')");
			
			// 업로드된 파일을 삭제하기 위해서 File 객체를 생성
			File file = new  File(application.getRealPath("/upload/") + fileRealname);
			// delete(): 파일을 삭제
			file.delete();
			
		} else if(!fileRealname.endsWith(".zip") && !fileRealname.endsWith(".txt")) { // 파일 종류 제한
			
			// *.zip 파일과 *.txt 파일만 업로드할 수 있도록 한다.
			// starstWith() : 인수로 지정된 문자열로 파일 이름이 시작되면 true, 그렇지 않으면 false 리턴
			// endsWith(): 인수로 지정된 문자열로 파일 이름이 끝나면 true, 그렇지 않으면 false 리턴
			
			out.println("alert('업로드 할 수 있는 형식의 파일이 아닙니다. \\nzip 파일과 .txt 파일만 가능합니다.')");
			File file = new  File(application.getRealPath("/upload/") + fileRealname);
			file.delete();
			
			
		} else {
			out.println("alert('업로드 성공!')");
			out.println("</script>");
			out.println("원본 파일 이름: " + filename + "<br/>");
			out.println("실제 업로드된 파일 이름: " + fileRealname + "<br/>");
			out.println("업로드한 파일 용량: " + fileLength + "<br/>");			
		}
		
		out.println("<script>");
		out.println("location.href='index.jsp'");
		out.println("</script>");
		
	%>

</body>
</html>