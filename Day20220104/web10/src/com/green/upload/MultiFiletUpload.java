package com.green.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload2")
public class MultiFiletUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 다수의 파일 업로드시 이름 처리 방법
		// 2. 파일 크기 처리   => 최대 크기는 모든 파일의 합계 크기
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 1. 업로드 위치
		String savePath = "C:\\IMG";
		// 2. 파일 크기   =>   업로드 되는 모든 파일의 합계 크기
		int uploadFileSizeLimit = 10*1024*1024;  //10MB
		// 3. 인코딩 타입
		String encType = "UTF-8";
		
		
		try {
			MultipartRequest multi = new MultipartRequest(
												request,
												savePath,
												uploadFileSizeLimit,
												encType,
												new DefaultFileRenamePolicy()
											);
				
			if(multi == null) {
				System.out.println("업로드 실패");
			}else {
				System.out.println("업로드 성공");
			}
			
			//-------------------------------------------------------------------------------
			Enumeration<String> fileNames = multi.getFileNames(); // form에서 넘겨준 name 모음
			//유사Set
			
			while(fileNames.hasMoreElements()) {
				String file = (String)fileNames.nextElement();  // 가져온 이름 name: uploadFile01,uploadFile02,uploadFile03
				String fileName = multi.getFilesystemName(file); //실제 저장된 파일 이름
				
				// 정책에 의해 변경되기 전 원본 파일명
				String originFileName = multi.getOriginalFileName(file);
				
				out.println("<br> 업로드된 파일명 : "+fileName);
				out.println("<br> 원본 파일명 : "+originFileName);
				out.println("<hr>");
				
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
