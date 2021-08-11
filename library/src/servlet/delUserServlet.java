package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

/**
 * Servlet implementation class delUserServlet
 */
@WebServlet("/delUserServlet")
public class delUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		Service s=new Service();
		PrintWriter printWriter = response.getWriter();
		if(s.delUser(id)) {
			//request.getRequestDispatcher("user-list.jsp").forward(request, response);
			printWriter.print("<script>alert('É¾³ý³É¹¦£¡');window.location='"+request.getContextPath()+"/success.jsp';</script>");
		}else {
			printWriter.print("<script>alert('É¾³ýÊ§°Ü£¡');window.location='"+request.getContextPath()+"/user-list.jsp';</script>");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
