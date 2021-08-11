package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.Service;

/**
 * Servlet implementation class borrowBookServlet
 */
@WebServlet("/borrowBookServlet")
public class borrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowBookServlet() {
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
		HttpSession session = request.getSession();
		User u=(User) session.getAttribute("user");
		System.out.print("这是显示个人信息的：");
		int id1=u.getId();
		int id2=Integer.parseInt(request.getParameter("id"));
		int actor=Integer.parseInt(request.getParameter("actor"));
		int uBorrow=Integer.parseInt(request.getParameter("uBorrow"));
		PrintWriter printWriter = response.getWriter();
		if(actor==0 && uBorrow > 5) {//教师
			printWriter.print("<script>alert('您借书已达限制，不可再借！');window.location='"+request.getContextPath()+"/fail.jsp';</script>");
		    return ;
		}else {
			Service s=new Service();
			if(s.borrowBook(id1,id2,actor)) {
				request.getRequestDispatcher("book-list.jsp").forward(request, response);
			}else {
				response.sendRedirect("detail.jsp?message=error");
				return;
			}
		}
		if(actor==1 && uBorrow > 3) {//学生
			printWriter.print("<script>alert('您借书已达限制，不可再借！');window.location='"+request.getContextPath()+"/fail.jsp';</script>");
			return;
		}else {
			Service s=new Service();
			if(s.borrowBook(id1,id2,actor)) {
				System.out.print("借书了");
				request.getRequestDispatcher("book-list.jsp").forward(request, response);
			}else {
				response.sendRedirect("detail.jsp?message=error");
				
			}
		}

		if(actor==2 && uBorrow > 2) {//其他人
			printWriter.print("<script>alert('您借书已达限制，不可再借！');window.location='"+request.getContextPath()+"/fail.jsp';</script>");
		    return ;
		}else {
			Service s=new Service();
			if(s.borrowBook(id1,id2,actor)) {
				request.getRequestDispatcher("book-list.jsp").forward(request, response);
			}else {
				response.sendRedirect("detail.jsp?message=error");
				return;
			}
		}
	}

}
