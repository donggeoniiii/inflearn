package hello.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	// 서블릿이 호출되면 이 메서드가 실행됨
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("HelloServlet.service");
		System.out.println("request = " + request);
		System.out.println("response = " + response);

		// 쿼리 스트링에서 "username" 파라미터의 값을 읽어옴
		String username = request.getParameter("username");
		System.out.println("username = " + username);

		// 헤더 정보
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		
		// 화면에 표시할 텍스트
		response.getWriter().write("hello " + username);
	}
}
