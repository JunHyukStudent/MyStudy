package com.green.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upLoad")
public class FileUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 업로드 폴더
		String upload = "upload";
		
		// 서버상의 절대 주소
		String savePath = "C:\\IMG";
		// 서버상의 상대주소
		ServletContext context = getServletContext();
		String savePath2 = context.getRealPath(upload);
		///   						\\web10\\WebContent\\upload
		
		// 파일 사이즈
		int uploadFileSizeLimit = 10*1024*1024;  //10MB
		
		// 인코딩 타입
		String encType = "UTF-8";
		
		try {
			//MultipartRequest multi = new MultipartRequest(request,"C:\\IMG",(10*1024*1024),"UTF-8",new DefaultFileRenamePolicy());
				//   MultipartRequest 객체 생성시 필요한 매개값
				// 1. Request객체 필요
				// 2. 파일 저장 위치  "C:\\IMG"
				// 3. 파일의 최대 크기 : 단위는 Byte => 10MB = 10KB*1024 => 10(Byte)*1024*1024;
				// 4. 파일 이름 인코딩 방식 : 한글 => UTF-8
				// 5. 파일 정책 : (동일한 파일명이 있을 경우 어떻게 처리할 것인가??)
				//     => 미리 만들어진 클래스를 이용   DefaultFileRenamePolicy
				//					=> 동일 파일명이 있을 경우 1,2,3, 번호를 매겨서 파일 업로드
			
			MultipartRequest multi = new MultipartRequest(
											request,
											savePath2,
											uploadFileSizeLimit,
											encType,
											new DefaultFileRenamePolicy()
											);
			
			String fileName = multi.getFilesystemName("fileUpload"); //  fileUpload: 파일이름(파일);
			// 업로드가 정상적으로 이루어 졌다면 파일 이름을 읽어올수 있다.
			
			if(fileName == null) { // 업로드 실패
				System.out.println("업로드 실패");
			}else {// 업로드 성공
				out.println("<br> 글쓴이 : "+multi.getParameter("name"));
				out.println("<br> 글 제목 : "+multi.getParameter("title"));
				out.println("<br> 파일명 : "+ fileName);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
