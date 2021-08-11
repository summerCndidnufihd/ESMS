package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import entity.User;
import service.Service;

/**
 * Servlet implementation class editSubmitServlet
 */
@WebServlet("/editSubmitServlet")
public class editSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSubmitServlet() {
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
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		String book_name=request.getParameter("book_name");
		String book_author=request.getParameter("book_author");
		String book_publish=request.getParameter("book_publish");
		int book_haveNum=Integer.parseInt(request.getParameter("book_haveNum"));
		String book_type=request.getParameter("book_type");
		Book book=new Book();
		Service s=new Service();
		book.setBook_id(book_id);
		book.setBook_name(book_name);
		book.setBook_author(book_author);
		book.setBook_publish(book_publish);
		book.setBook_haveNum(book_haveNum);
		book.setBook_type(book_type);
		int a=0;
		a=s.updateBookInfo(book);
		PrintWriter printWriter = response.getWriter();
		if(a>0) {//修改成功
			printWriter.print("<script>alert('修改成功！');window.location='"+request.getContextPath()+"/success.jsp';</script>");
		}else {//失败
			printWriter.print("<script>alert('修改失败！');window.location='"+request.getContextPath()+"/success.jsp';</script>");
		}
	}

}
