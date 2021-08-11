package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import service.Service;

/**
 * Servlet implementation class borrowBookInfoList
 */
@WebServlet("/borrowBookInfoList")
public class borrowBookInfoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowBookInfoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Book> list=new ArrayList<Book>();
		Service s=new Service();
		list=s.bookList();
		if(list!=null) {
			System.out.print("借书信息：");
			System.out.print(list);
			request.setAttribute("book", list);
			request.getRequestDispatcher("checkBookList.jsp").forward(request, response);
		}else {
			System.out.print("-----列表：");
			request.setAttribute("book", list);
			request.getRequestDispatcher("checkBookList.jsp").forward(request, response);
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
