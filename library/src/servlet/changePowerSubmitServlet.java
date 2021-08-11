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
 * Servlet implementation class changePowerSubmitServlet
 */
@WebServlet("/changePowerSubmitServlet")
public class changePowerSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePowerSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int actor=Integer.parseInt(request.getParameter("actor"));
		int uMaxBorrow=Integer.parseInt(request.getParameter("uMaxBorrow"));
		int borrow_end=Integer.parseInt(request.getParameter("borrow_end"));
		Service s=new Service();
		int a=0;
		a=s.changePower(actor,uMaxBorrow,borrow_end);
		PrintWriter printWriter = response.getWriter();
		if(a>0) {//修改成功
			printWriter.print("<script>alert('修改成功！');window.location='"+request.getContextPath()+"/success.jsp';</script>");
		}else {//失败
			printWriter.print("<script>alert('修改失败！');window.location='"+request.getContextPath()+"/success.jsp';</script>");
		}
	}

}
