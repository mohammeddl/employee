package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class testController extends HttpServlet {
    
   public void doGet( HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException, ServletException {
    request.setAttribute( "message", "Hello World!-------------------" );
    request.getRequestDispatcher( "index.jsp" ).forward( request, httpServletResponse );
   }
}
